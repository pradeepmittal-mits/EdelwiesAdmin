package com.fn.edw.agmt.eventHandler;

import java.util.Iterator;

import com.filenet.api.collection.IndependentObjectSet;
import com.filenet.api.constants.AutoUniqueName;
import com.filenet.api.constants.DefineSecurityParentage;
import com.filenet.api.constants.FilteredPropertyType;
import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Connection;
import com.filenet.api.core.CustomObject;
import com.filenet.api.core.Document;
import com.filenet.api.core.Factory;
import com.filenet.api.core.Folder;
import com.filenet.api.core.IndependentObject;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.core.ReferentialContainmentRelationship;
import com.filenet.api.engine.EventActionHandler;
import com.filenet.api.events.ObjectChangeEvent;
import com.filenet.api.exception.EngineRuntimeException;
import com.filenet.api.property.Properties;
import com.filenet.api.property.PropertyFilter;
import com.filenet.api.query.SearchSQL;
import com.filenet.api.query.SearchScope;
import com.filenet.api.util.Id;

public class ArgreementCheckInEventHandler implements EventActionHandler {

	@Override
	public void onEvent(ObjectChangeEvent obj, Id objId) throws EngineRuntimeException {

		
		System.out.println(" Event Triggered ");
		ObjectStore os = obj.getObjectStore();
		Connection conn = obj.getConnection();
		// System.out.println("This is test event for with Document
		// Class********************************");
		// getting the IndependentObject and taking it as a document on which
		// the creation or check-In event is triggered

		IndependentObject independentObj = obj.get_SourceObject();

		Document doc = (Document) independentObj;
		// getting the custom properties of the Document Object
		Properties properties = doc.getProperties();
		
		String propertyRegion = properties.get("Region_ED").getStringValue();
		String propertyState = properties.get("State").getStringValue();
		String propertyCity = properties.get("City").getStringValue();
		String propertyLocationCode = properties.get("UniqueCode").getStringValue();
		String propertyEntity = properties.get("Entity").getStringValue();
		String propertyFunction = properties.get("Function").getStringValue();
		String propertyDocumentType = properties.get("Document_Type").getStringValue();
		
		
		propertyLocationCode = propertyLocationCode.replaceAll("\\|", "-");

		// Creating the folder location based on the custom property values
		String folderlocation = "/" + propertyRegion + "/" + propertyState +"/" + propertyCity + "/" + propertyLocationCode + "/"
				+ propertyEntity  + "/" + propertyFunction + "/" + propertyDocumentType;
		System.out.println("folderlocation :\n" + folderlocation);
		String fnFolders[] = folderlocation.split("/");
		String folderParent = "";
		// loop for checking and creating the Folder structure based on the
		// folderlocation formed by given custom properties
		for (int i = 1; i < fnFolders.length; i++) {

			if (i == 1) {
				folderParent = "/";
			}

			String fnFolder = fnFolders[i];
			if (!fnFolder.equalsIgnoreCase("") && fnFolder != null) {
				System.out.println("parent folder :" + folderParent);
				System.out.println("fnFolder :" + fnFolder);
				boolean checkFolder = checkfnFolder(folderParent + "/" + fnFolder, os, conn);
				System.out.println("response of checkfnFolder :" + checkFolder);
				if (checkFolder == false) {
					boolean createFolderFlag = createfnFolder(fnFolder, folderParent, os, conn);
				}
				if (i == 1) {
					folderParent = folderParent + fnFolder;
				} else {
					folderParent = folderParent + "/" + fnFolder;
				}

			}

			System.out.println("folderParent :" + folderParent);
		}

		System.out.println("Property Value for the Region: " + propertyRegion);

		String filenetFolderLocation = folderParent;
		String customObjecId = null;
		customObjecId = getCustomObjectId(propertyRegion, os, conn);
		System.out.println("CustomObjectName :" + customObjecId);
		//PropertyFilter pf = new PropertyFilter();
		//pf.addIncludeType(0, null, Boolean.TRUE, FilteredPropertyType.ANY, null);
		CustomObject customobj = Factory.CustomObject.fetchInstance(os, new Id(customObjecId), null);
		System.out.println("customobj : " + customobj);
		String fileName = properties.get("DocumentTitle").getStringValue();
		System.out.println("Document Title : " + fileName);
		Id docId = doc.get_Id();
		Document document = Factory.Document.fetchInstance(os, docId, null);
		document.getProperties().get("edw_admin_sec_proxy").setObjectValue(customobj);
		document.save(RefreshMode.REFRESH);
		System.out.println("Security Proxy has been set Sucessfully");
		System.out.println("filenetFolderLocation : " + filenetFolderLocation);
		Folder folder = Factory.Folder.fetchInstance(os, filenetFolderLocation, null);

		ReferentialContainmentRelationship rel = folder.file(document, AutoUniqueName.AUTO_UNIQUE, fileName,
				DefineSecurityParentage.DEFINE_SECURITY_PARENTAGE);
		rel.save(RefreshMode.REFRESH);
		System.out.println("Document Filed in location : " + filenetFolderLocation);
		// fc.closeConnection();

	}

	private String getCustomObjectId(String propertyRegion, ObjectStore os, Connection fn) {
		// TODO Auto-generated method stub
		String customObjectId = "";
		SearchScope scope = new SearchScope(os);
		SearchSQL sql = new SearchSQL("SELECT * FROM Agmt_Sec_Proxy WHERE Region_ED = '" + propertyRegion + "'");
		IndependentObjectSet independentObj = scope.fetchObjects(sql, new Integer(100), null, null);
		Iterator iterator = independentObj.iterator();
		while (iterator.hasNext()) {
			CustomObject customObject = (CustomObject) iterator.next();
			customObjectId = customObject.get_Id().toString();
		}
		return customObjectId;
	}

	private boolean createfnFolder(String fnFolder, String fnFolderLocation, ObjectStore os, Connection fn) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			String classType = "Folder";
			// parent Folder instance fetch
			Folder folderlocation = Factory.Folder.fetchInstance(os, fnFolderLocation, null);
			// Create the Folder 
			Folder folderObj = Factory.Folder.createInstance(os, classType);
			// setting the Folder Name
			folderObj.set_FolderName(fnFolder);
			// setting the Folder Location
			folderObj.set_Parent(folderlocation);
			// save the folder
			folderObj.save(RefreshMode.REFRESH);
			flag = true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return flag;
	}

	private boolean checkfnFolder(String fnFolder, ObjectStore os, Connection fn) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			Folder folderObj = Factory.Folder.fetchInstance(os, fnFolder, null);
			flag = true;
		} catch (Exception e) {
			System.err.println(e);
		}
		return flag;
	}
 public static void main(String[] args) {
	
	 
	 String s = new String("asd|asdasd|sadfsa");
	 s.replaceAll("\\|", "-");
	 System.out.println(s);
	 
}
	
}
