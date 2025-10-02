[ REPOSITORIO GITHUB ]
https://github.com/MedievAlex/ADTi_Reto_0_Conecta_-Alex_Ekaitz_Kevin_Victor-.git

[ JAVADOC ]
dist/javadoc/index.html

[ METODOS Y SUS LLAMADAS ]
-> main
---> Main

------> [ 1 ] Create a new TEACHING UNIT
---------> cont.newTeachingUnit()

------> [ 2 ] Create a new EXAM STATEMENT
---------> cont.newExamStatement()

------> [ 3 ] Create a EXAM SESSION
---------> cont.newExamSession()

------> [ 4 ] Consult the EXAM STATEMENT by TEACHING UNIT
---------> cont.consultStatementByTeachingUnit()

------> [ 5 ] Consult in which EXAM SESSIONS a specific EXAM STATEMENT has been used
---------> cont.consultSessionsByStatement()

------> [ 6 ] Open EXAM STATEMENTS
---------> cont.openExamStatements()

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
---------> countAllExamStatements()
---------> con.prepareStatement(SQLINSERT_EXAMSTATEMENT)
---------> newStatementForUnit(teachingUnit, examStatement)

------> showAllExamStatements()
---------> con.prepareStatement(SQLSELECT_ALLEXAMSTATEMENTS)

------> countAllExamStatements()
---------> con.prepareStatement(SQLSELECT_ALLEXAMSTATEMENTS)

------> getExamStatementsRoute(ExamStatement examStatement)
---------> con.prepareStatement(SQLSELECT_EXAMSTATEMENTROUTE)

------> newStatementForUnit(TeachingUnit teachingUnit, ExamStatement examStatement)
---------> con.prepareStatement(SQLINSERT_STATEMENTUNIT)

------> newExamSession()
---------> showAllExamStatements();
---------> verifyExamStatement(examStatement);
---------> con.prepareStatement(SQLINSERT_EXAMSESSION)

------> consultStatementByTeachingUnit()
---------> showAllTeachingUnits()
---------> verifyTeachingUnit(teachingUnit)
---------> con.prepareStatement(SQLSELECT_EXAMSTATEMENTBYTEACHINGUNIT) 

------> consultSessionsByStatement()
---------> showAllExamStatements()
---------> verifyExamStatement(examStatement)
---------> con.prepareStatement(SQLSELECT_EXAMSESSIONBYEXAMSTATEMENT)

------> openExamStatements()
---------> showAllExamStatements()
---------> verifyExamStatement(examStatement)
---------> getExamStatementsRoute(examStatement)