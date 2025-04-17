SELECT TOP (1000) [id]
      ,[content]
  FROM [XSSDemo].[dbo].[comment]
  DELETE FROM comment 
WHERE content LIKE '%<script>window.location.href = "http://attacker.com/malicious-page";</script>%';