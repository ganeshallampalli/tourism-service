# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)




/**
	 * Converts Excel File into list of rows as Map[ColumnName, CellValue].
	 * 
	 * @return
	 */
	public List<Map<String, String>> convertExcelToHashMap(String filePath) {

		Map<String, String> dataMap = new HashMap<>();
		List<Map<String, String>> excelRowValues = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			String key;
			String value;
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> it = sheet.rowIterator();

			// Header row of the excel sheet
			Row headerRow = it.next();

			while (it.hasNext()) {
				Row row = it.next();
				for (int i = 0; i < headerRow.getLastCellNum(); i++) {
					if ((null != row.getCell(i)) && (row.getCell(i).getCellTypeEnum() == CellType.NUMERIC)) {
						if (DateUtil.isCellDateFormatted(row.getCell(i))) {
							DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							value = dateFormat.format(row.getCell(i).getDateCellValue()).trim();
						} else {
							row.getCell(i).setCellType(CellType.STRING);
							value = row.getCell(i).toString().trim();
						}
						key = headerRow.getCell(i).toString().trim();
					} else {
						key = (headerRow.getCell(i) + "".toString()).trim() + "";
						value = (null != row.getCell(i)) ? (row.getCell(i) + "".toString()).trim() + "" : "";
					}
					dataMap.put(key, value);
				}
				excelRowValues.add(dataMap);
				dataMap = new HashMap<>();
			}
			LOGGER.debug("{}", excelRowValues);
			workbook.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return excelRowValues;
	}
