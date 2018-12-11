package com.example.madbarzapp.data;

import com.example.madbarzapp.models.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CriteriaExerciseRep {

    @Autowired
    private EntityManager em;

    public List<Exercise> findExercisesByName(String exerciseName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Exercise> cq = cb.createQuery(Exercise.class);

        Root<Exercise> exercise = cq.from(Exercise.class);
        Predicate exerciseNamePredicate = cb.like(exercise.get("name"), "%" + exerciseName + "%");
        cq.where(exerciseNamePredicate);

        TypedQuery<Exercise> query = em.createQuery(cq);
        return query.getResultList();
    }
}
