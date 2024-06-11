
package com.example.casestudymd4.model;

import java.util.List;

public enum FeeStatusEnum {
    NO_HOC_PHI {
        @Override
        public List<Student> getStudentsByUserId(Long userId) {
            return null;
        }

        @Override
        public List<Student> getStudentsByClassId(Long classId) {
            return null;
        }

        @Override
        public List<Student> getStudentsByStatus(StudentStatus status) {
            return null;
        }
    }, DA_DONG {
        @Override
        public List<Student> getStudentsByUserId(Long userId) {
            return null;
        }

        @Override
        public List<Student> getStudentsByClassId(Long classId) {
            return null;
        }

        @Override
        public List<Student> getStudentsByStatus(StudentStatus status) {
            return null;
        }
    };

    public abstract List<Student> getStudentsByUserId(Long userId);

    public abstract List<Student> getStudentsByClassId(Long classId);

    public abstract List<Student> getStudentsByStatus(StudentStatus status);
}
