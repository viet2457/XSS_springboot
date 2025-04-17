use XSSDemo
DELETE FROM comment 
WHERE content LIKE '%<script>document.body.innerHTML='' <h1>Hacked by XSS</h1>'';</script>%';