SELECT p.name as person_name, c.name as company_name from person p
    left join company c on p.company_id = c.id
    where p.company_id != 5 and c.id is not null;

SELECT c.company_id, c.company_count as company_max FROM (
    SELECT p.company_id, COUNT(p.company_id) AS company_count FROM person p GROUP BY p.company_id) c
	where c.company_count = (
	SELECT MAX(company_count) AS max_company_count FROM (
    SELECT p.company_id, COUNT(p.company_id) AS company_count
    FROM person p
    GROUP BY p.company_id
	));
