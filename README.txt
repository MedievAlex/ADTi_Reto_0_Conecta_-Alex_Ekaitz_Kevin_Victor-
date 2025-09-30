[ COSAS POR TERMINAR ]

-> main
---> Main

------> [ 1 ] Create a new TEACHING UNIT
---------> cont.newTeachingUnit()

------> [ 2 ] Create a new EXAM STATEMENT
---------> cont.newExamStatement()
---------> cont.newStatementForUnit(teachingUnit, )

------> [ 3 ] Create a EXAM SESSION
---------> cont.newExamSession()

------> [ 4 ] Consult the EXAM STATEMENT by TEACHING UNIT
---------> cont.consultStatementByTeachingUnit()

------> [ 5 ] Consult in which EXAM SESSIONS a specific EXAM STATEMENT has been used
---------> cont.consultSessionsByStatement()

-> model
---> DBImplementation

------> verifyTeachingUnit(TeachingUnit teachingUnit)
---------> con.prepareStatement(SQLSELECT_TEACHINGUNIT)

------> newTeachingUnit()
---------> verifyTeachingUnit(teachingUnit)
---------> con.prepareStatement(SQLINSERT_TEACHINGUNIT)

------> showAllTeachingUnits()
---------> con.prepareStatement(SQLSELECT_ALLTEACHINGUNITS)

------> verifyExamStatement(ExamStatement examStatement)
---------> con.prepareStatement(SQLSELECT_EXAMSTATEMENT)

------> newExamStatement()
---------> showAllTeachingUnits()
---------> verifyTeachingUnit(teachingUnit)
---------> con.prepareStatement(SQLINSERT_EXAMSTATEMENT)
---------> newStatementForUnit(teachingUnit, examStatement)

------> showAllExamStatements()
---------> con.prepareStatement(SQLSELECT_ALLEXAMSTATEMENTS)

------> newStatementForUnit(TeachingUnit teachingUnit, ExamStatement examStatement)

------> newExamSession()
---------> showAllExamStatements();
---------> verifyExamStatement(examStatement);
---------> con.prepareStatement(SQLINSERT_EXAMSESSION)

------> consultStatementByTeachingUnit()
---------> showAllTeachingUnits()
---------> verifyTeachingUnit(teachingUnit) 

------> consultSessionsByStatement()
---------> showAllExamStatements()
---------> verifyExamStatement(examStatement)
