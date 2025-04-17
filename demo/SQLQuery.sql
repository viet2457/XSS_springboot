SELECT TOP (1000) [id]
      ,[content]
  FROM [XSSDemo].[dbo].[comment]
DELETE FROM comment 
WHERE content LIKE '%Hacked by XSS%';
