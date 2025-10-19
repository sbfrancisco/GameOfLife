Feature: Estado inicial del tablero

  Scenario: Inicializar el juego con un estado inicial y computar una generacion
    Given este estado inicial del tablero
      """
      . . . . .
      . . B . .
      . R R B .
      . . R . .
      . . . . .
      """
    And el juego fue inicializado con la regla "inmigration"
    When se computa una nueva generacion
    Then el tablero deberia ser
    """
    . . . . .
    . R B B .
    . R . B .
    . R R R .
    . . . . .
    """

  Scenario: Inicializar el juego con un estado inicial
    Given este estado inicial del tablero
      """
      . . . . .
      . . B . .
      . R R B .
      . . R . .
      . . . . .
      """
    And el juego fue inicializado con la regla "inmigration"
    Then el tablero deberia ser
    """
    . . . . .
    . . B . .
    . R R B .
    . . R . .
    . . . . .
    """



