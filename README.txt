[ COSAS POR TERMINAR ]

-> controller

---> Controller
------> showAllTeachingUnits
------> newStatementForUnit
------> showAllExamStatements
------> consultStatementByTeachingUnit
------> consultSessionsByStatement


-> main

---> Main
------> createExamStatement (showAllTeachingUnits is missing)
------> createExamSession (showAllExamStatements is missing)
------> checkStatementByTeachingUnit
------> checkSessionsByStatement


-> model

---> DBImplementation
------> showAllTeachingUnits
------> newStatementForUnit (Creates the table StatementUnit)
------> showAllExamStatements
------> consultStatementByTeachingUnit
------> consultSessionsByStatement

---> ModelDAO
------> showAllTeachingUnits
------> newStatementForUnit
------> showAllExamStatements
------> consultStatementByTeachingUnit
------> consultSessionsByStatement
