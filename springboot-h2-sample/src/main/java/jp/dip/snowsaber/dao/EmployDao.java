package jp.dip.snowsaber.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jp.dip.snowsaber.dto.Employ;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmployDao {

	private DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Employ> findAll() throws Exception {
		Connection conn = dataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select * from employ");
		ResultSet rs = ps.executeQuery();

		List<Employ> list = new ArrayList<>();
		while (rs.next()) {
			Employ employ = new Employ();
			employ.setId(rs.getString("id"));
			employ.setName(rs.getString("name"));
			employ.setAge(rs.getInt("age"));
			list.add(employ);
		}

		return list;
	}
}
