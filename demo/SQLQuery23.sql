SELECT TOP (1000) [id]
      ,[content]
  FROM [XSSDemo].[dbo].[comment]
  DELETE FROM comment
WHERE content LIKE '%<script>%'
   OR content LIKE '%window.location%'
   OR content LIKE '%fetch(%'
   OR content LIKE '%document.cookie%';