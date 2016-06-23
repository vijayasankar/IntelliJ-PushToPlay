@db
Feature: To test database validation

#Scenario: DB001 User record creation in Opted_game Table

#select id,mobile_number, dip_type, favourite_name, status, wager_amount, send_reminder from push2play_int3.opted_game order by created desc limit 1

#Scenario: DB002 User record is not created by missing any of the inputs

#Scenario: DB003 User opts out
#select id,mobile_number, dip_type, favourite_name, status, wager_amount, send_reminder from push2play_int3.opted_game order by created desc limit 1

#Scenario: DB004 Transaction and Ticket Table record creation
#select * from push2play_int3.transation LEFT JOIN push2play_int3.tickets on transation.id = tickets.transaction_id order by created desc limit 1 