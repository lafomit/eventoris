<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

	<footer style="">
		<div class = "social-networks">
			<div class="container clearfix">
				<div class = "grid_3">
					<div class = "facebook"><a onclick="Share.facebook('https://www.google.com','Eventoris','resources/img/logo_03.png','Hai cu noi! Să ne distrăm, să fim mai buni, să fim prieteni!')"> Facebook</a></div>
				</div>
				<div class = "grid_3">
					<div class = "google">
					<a onclick="Share.google('https://www.google.com','Eventoris','resources/img/logo_03.png','Hai cu noi! Să ne distrăm, să fim mai buni, să fim prieteni!')">Google +</a>
					<!-- <a href="https://plus.google.com/share?url=http://www.simplesharebuttons.com" target="_blank">Google +</a> -->
					</div>
				</div>
				<div class = "grid_3">
					<div class = "odnoklassniki"><a onclick="Share.odnoklassniki('URL','DESC')">Одноклассники</a></div>
				</div>
				<div class = "grid_3">
					<div class = "vkontakte"><a onclick="Share.vkontakte('https://www.google.com','Eventoris','resources/img/logo_03.png','Hai cu noi! Să ne distrăm, să fim mai buni, să fim prieteni!')"> ВКонтакте</a></div>
				</div>
			</div>
		</div>
		<div class="copyright">
			<div class = "container clearfix">
				<div class="grid_12">
					<p>Copyright 2014</p>
				</div>
			</div>
		</div>
	</footer>
	<div id="fb-root"></div>
	<script>
	Share = {
		    vkontakte: function(purl, ptitle, pimg, text) {
		        url  = 'http://vkontakte.ru/share.php?';
		        url += 'url='          + encodeURIComponent(purl);
		        url += '&title='       + encodeURIComponent(ptitle);
		        url += '&description=' + encodeURIComponent(text);
		        url += '&image='       + encodeURIComponent(pimg);
		        url += '&noparse=true';
		        Share.popup(url);
		    },
		    google: function(purl, ptitle, pimg, text) {
		        url  = 'https://plus.google.com/share?';
		        url += 'url='          + encodeURIComponent(purl);
		        url += '&title='       + encodeURIComponent(ptitle);
		        url += '&description=' + encodeURIComponent(text);
		        url += '&image='       + encodeURIComponent(pimg);
		        url += '&noparse=true';
		        Share.popup(url);
		    },
		    odnoklassniki: function(purl, text) {
		        url  = 'http://www.odnoklassniki.ru/dk?st.cmd=addShare&st.s=1';
		        url += '&st.comments=' + encodeURIComponent(text);
		        url += '&st._surl='    + encodeURIComponent(purl);
		        Share.popup(url);
		    },
		    facebook: function(purl, ptitle, pimg, text) {
		        url  = 'http://www.facebook.com/sharer.php?s=100';
		        url += '&p[title]='     + encodeURIComponent(ptitle);
		        url += '&p[summary]='   + encodeURIComponent(text);
		        url += '&p[url]='       + encodeURIComponent(purl);
		        url += '&p[images][0]=' + encodeURIComponent(pimg);
		        Share.popup(url);
		    },
		    popup: function(url) {
		        window.open(url,'','toolbar=0,status=0,width=626,height=436');
		    }
	}
	</script>
</body>