<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<app name="Edelweiss_N" ver="31" modder="administrator.MITSDEMO.SQL" dt="09/14/18 17:32:03.418 " src_ver="5">
	<k name="tmservers">
		<k name="tms" ip="127.0.0.1" port="2402" retry="3" protocol="300"/>
	</k>
	<k name="runtime" v="batches"/>
	<k name="tmengine" cs="[secured]014101f59c4023c1261900509d793c2b213b0bff9a3dcfabce46015e650d80f7118b82560a545125704158722a0bc2f7cf46b317f7c6b273db71da7a51e5410efe30cadfffbc39545c769f001d80da29d09c3355a49b02c5246bec4b30660001a39f7adccd8ca01b1d75649835bca75e4a6c1c688551b9e3ead40988072d8ee4f0e74e108ecc18f9d0ac53ca9a3f9ba4dfe3ea2487e7f1afecfa3f62d962e5a62bb61e56ebb97dc0982a40475a7399521d9bec4f7b756889437faa6a079f95cc6301faf408e894475b342546706a2ed267[/secured]"/>
	<k name="tmadmin" cs="[secured]01ba0976e009af98d62998a4790eecaf16c3dc2df2a8d31acc2303dc6c8da3ee273f2a30bfa3253f78023282fac204279b8252a23e5284fa83fa1930d93770abb22e99d0041b6ad80e056eff72f9f683cdb750ebe9947509b69c8a956c731e891b569361a8864bcf37ad27315db8d67f7569ea2b69b202eb58b1b0cb25753e0ffd9b52f11835cb374b2ffb1473dc46c6cf8dbf07d64dad6f9ff1e9da03e6099ef37765458431530c5c6b5d1041f7173322ab9dec1108a7c6ab53e1b9570c66da319bcda9ec319ecc7ec600954e9626f7a5[/secured]"/>
	<k name="dco_Edelweiss_N">
		<k name="setupdco" v="Edelweiss_N.xml"/>
		<k name="rules" v="rules"/>
		<k name="imagefix" v="imagefix.ini"/>
		<k name="UseFPXML" v="False"/>
		<k name="fingerprintconn" cs="[secured]016d35d532739d94def5aa208d08e1d069bfb58d04413ea84b162753ab19fdb770ddfa83ca895a8ec4c41765bcab62d06f6b1ba89e78608b5c7b2a1b4a7ce6e2f5b58572af2f703cad9be96bc0eeab08f1804c1e6e602b92dbcdbfc8812b41af91193f9c8dbe3ca03e565328ccda730b837452313f27ea573b36de4722f536d80e34ded751a667ed8978fd590c45ca71313880d2b2b9fcfa6ab1258ad8fae855efc449a619545d877ccdafe1059847e4e52e23a45bc27d9c525b760bb6d3928072e655ee8a2da1a510b3c5e32064043b8711f84a6462b73c959cb8ad9ba2af0e35[/secured]"/>
		<k name="lookupdb" cs="[secured]01533afac1528ee4fc7233a8e44aaf8478f7e10de7af1d5df6e5669aefb554bdb18ff6605c0da23a6961852d883c23cd2a76930250c96083a2706807573bf9a76cec23c4b6cbe2e68e4d9b852e11d7e72c9ff9a7fbb7464c5434fb4500c289765f40757be7725c0dabdab96fed656f6ce650b30be7e9dc2c51ad257478b1764d101f5a727e79e4cb0881c001a154a8cd9ac9efc36a8dc465a85f32e483b29d78a6866e635448faf0b25e07dcb203f51ff0f491a896437d648d8c0d6ae9f64968f2b9e76b34a4bff03348670c708047ad4e[/secured]"/>
		<k name="vscanimagedir" v="C:\Datacap\Edelweiss_N\images\InputImages"/>
		<k name="vscanimagedir_Multi" v="C:\Datacap\Edelweiss_N\images\Input_MultiFormat"/>
		<k name="exportdb" cs="[secured]01efef52baa316aab7e66e7c558435f99725a48b8db484502fe04dd1713c710064b022364d927e1914fd4e0b6fd9efbff825073a188753a45ac63a2a32e3e30413[/secured]"/>
		<k name="copyimagedir" v="C:\Datacap\Edelweiss_N\images\Input_SingleTIFFs"/>
		<k name="locale" v=""/>
		<k name="SaveReportStatistics" v="False"/>
	</k>
	<k name="fingerprint" v="fingerprint"/>
	<k name="export" v="export"/>
	<k name="tasks">
		<k name="VScan" profile="VScan"/>
		<k name="PageID" profile="PageID"/>
		<k name="Profiler" profile="Profiler"/>
		<k name="Export" profile="Export"/>
	</k>
	<k name="values">
		<k name="gen">
			<k name="MovetoDirectory" v="[encoded].DJnAfX8E6FiV37a5q30yZDsLDvRFTF7Y37R5GW96Nr4Yj9qq0Ws6OxCUD7CABeH1ZZ0yS5Ld9fB6wnBoF3AfCFtAe7D5B1KZ0Wq6Ov3xk7C77Nu[/encoded]"/>
			<k name="FilenetUrl" v="[encoded].4n7AfE8Dw2vuFueEMj9VI5LV5Oa6wT7XjFxm3jh6NZ0IG5aQ4mp28y3xzBSe37u1a00yt5La18aBCzG4UFxh3jFAdxD581KW93SAfN8ECFiw37hEMR9Uu5Li[/encoded]"/>
			<k name="ObjectStore" v="[encoded].4nG6P23xoBSE7Nz5pp5Ef5Li18YBD7[/encoded]"/>
			<k name="FilenetUserName" v="[encoded].4n5Evn8E1Fid7NpA6CDlI[/encoded]"/>
			<k name="UploadImage" v="[encoded].DJnAfX8E6FiV37a5q30yZDsLDvRFTF7Y37R5GW96Nr4Yj9qq0Ws6OxCUD7CABeH1ZZ9Uy9bsDvN2gY7Xz7QwGW9EuK4Yj1KO0WdEvb3xm7C67NrEMVDlP[/encoded]"/>
		</k>
		<k name="adv">
			<k name="FilenetPassword" v="[secured]017f767246b152ae63b6b16c4ac1338666e4f3bdb33079ae7cbb24e8458dcdf55d8146f599ad1c687314d7dabb9390278dee4d6ce900c0bc8eb719d94535ef4a86[/secured]"/>
		</k>
	</k>
	<k name="BatchNew" v=""/>
	<k name="QBy" v=""/>
	<k name="RoleMode" v=""/>
	<k name="Authenticator" v=""/>
	<k name="AutoImportNTGroups" v="True"/>
	<k name="Audit" v="True"/>
	<k name="SaveDeletedBatchInfo" v="True"/>
	<k name="InheritJobPriority" v="False"/>
</app>