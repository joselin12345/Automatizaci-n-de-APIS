Feature: Gestión de órdenes en PetStore

  @GestionOrdenes
  Scenario Outline: Crear y consultar una orden en PetStore

    Given la url del API de Store
    When creo una orden con petId <petId>, quantity <quantity>, status "<status>"
    Then el código de respuesta es 200
    And el status de la orden es "<status>"

    When consulto la orden con orderId <petId>
    Then el código de respuesta es 200
    And el petId es <petId>
    And la cantidad es <quantity>
    And el status es "<status>"

    Examples:
      | petId | quantity | status   |
      | 11    | 11       | placed   |
      | 12    | 12       | approved |
      | 13    | 13       | delivered|
