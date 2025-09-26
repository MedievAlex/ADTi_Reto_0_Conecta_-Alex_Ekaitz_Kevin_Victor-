[ COSAS POR TERMINAR ]

-> main
---> Main

------> createTeachingUnit(Controller cont)
---------> cont.verifyTeachingUnit(teachingUnit)
---------> cont.newTeachingUnit(teachingUnit)

------> createExamStatement(Controller cont)
---------> cont.showAllTeachingUnits()
---------> cont.verifyTeachingUnit(teachingUnit)
---------> cont.newExamStatement(examStatement)
---------> cont.newStatementForUnit(teachingUnit, examStatement)

------> createExamSession(Controller cont)
---------> cont.showAllExamStatements()
---------> cont.verifyExamStatement(examStatement)
---------> cont.newExamSession(examSession)

------> checkStatementByTeachingUnit(Controller cont) [ MISSING ]
---------> cont.consultStatementByTeachingUnit(teachingUnit)

------> checkSessionsByStatement(Controller cont) [ MISSING ]
---------> cont.consultSessionsByStatement(examStatement)

-> model
---> DBImplementation

------> verifyTeachingUnit(TeachingUnit teachingUnit)
---------> con.prepareStatement(SQLSELECT_TEACHINGUNIT)

------> newTeachingUnit(TeachingUnit teachingUnit)
---------> verifyTeachingUnit(teachingUnit)
---------> con.prepareStatement(SQLINSERT_TEACHINGUNIT)

------> showAllTeachingUnits()
---------> con.prepareStatement(SQLSELECT_ALLTEACHINGUNITS)

------> verifyExamStatement(ExamStatement examStatement)
---------> con.prepareStatement(SQLSELECT_EXAMSTATEMENT)

------> newExamStatement(ExamStatement examStatement)
---------> verifyExamStatement(examStatement)
---------> con.prepareStatement(SQLINSERT_EXAMSTATEMENT)

------> showAllExamStatements() [ ENUM Level need to be checked ]
---------> con.prepareStatement(SQLSELECT_ALLEXAMSTATEMENTS)

------> newStatementForUnit(TeachingUnit teachingUnit, ExamStatement examStatement) [ MISSING ]

------> newExamSession(ExamSession examSession)
---------> con.prepareStatement(SQLINSERT_EXAMSESSION)

------> consultStatementByTeachingUnit(TeachingUnit teachingUnit) [ MISSING ]

------> consultSessionsByStatement(ExamStatement examStatement) [ MISSING ]

