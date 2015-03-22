package com.sg.socrates.service.item.excel.mapping;

import com.sg.socrates.domain.empdeatil.EmployeeDetail;
import com.sg.socrates.service.item.excel.RowMapper;
import com.sg.socrates.service.item.excel.Sheet;

/**
 * Pass through {@link RowMapper} useful for passing the orginal String[] back
 * directly rather than a mapped object.
 * 
 * @author Nalini Ranjan
 * 
 */
public class PassThroughRowMapper implements RowMapper<EmployeeDetail> {

	public EmployeeDetail mapRow(final Sheet sheet, final String[] row,
			final int rowNum) throws Exception {
		EmployeeDetail employeeDetail = new EmployeeDetail();
		employeeDetail.setEmpId(row[0]);
		employeeDetail.setEmailId(row[1]);
		employeeDetail.setDateOfJoining(row[2]);
		employeeDetail.setFirstName(row[3]);
		employeeDetail.setLastName(row[4]);
		employeeDetail.setDepartement(row[5]);
		employeeDetail.setManagerName(row[6]);
		employeeDetail.setManagerEmpid(row[7]);
		employeeDetail.setManagerEmailId(row[8]);
		employeeDetail.setEmployeeAddress(row[9]);
		employeeDetail.setCity(row[10]);
		employeeDetail.setEmpHrId(row[11]);
		

		return employeeDetail;
	}

}