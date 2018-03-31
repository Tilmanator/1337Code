# Left outer join to include all people, even if they don't have an address

SELECT FirstName, LastName, City, State FROM
Person p
LEFT OUTER JOIN Address a
ON p.PersonId = a.PersonId