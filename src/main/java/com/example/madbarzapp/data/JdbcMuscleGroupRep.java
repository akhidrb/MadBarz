package com.example.madbarzapp.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.madbarzapp.models.MuscleGroup;

@Repository
public class JdbcMuscleGroupRep implements MuscleGroupRep {

	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcMuscleGroupRep(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public Iterable<MuscleGroup> findAll() {
		String query = "Select * from MuscleGroup";
		return jdbc.query(query, this::mapRowToMuscleGroup);
	}
	
	@Override
	public MuscleGroup findById(Long id) {
		String query = "Select * from MuscleGroup where id = ?";
		return jdbc.queryForObject(query, this::mapRowToMuscleGroup, id);
	}

	private MuscleGroup mapRowToMuscleGroup(ResultSet rs, 
			int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		String name = rs.getString("name");
		return new MuscleGroup(id, name);
	}
	
}

