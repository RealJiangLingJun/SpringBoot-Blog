(function($){
	// Settings
	var	playlist = [
		{title:"山楂树の恋",artist:"程jiajia",mp3:"/musicPlayer/mp3/程jiajia-山楂树の恋.mp3",cover:"/musicPlayer/img/山楂树之恋.jpg",},
		{title:"你的背包",artist:"陈奕迅",mp3:"/musicPlayer/mp3/陈奕迅-你的背包.mp3",cover:"/musicPlayer/img/你的背包.jpg",},
		{title:"苦瓜",artist:"陈奕迅",mp3:"/musicPlayer/mp3/陈奕迅-苦瓜.mp3",cover:"/musicPlayer/img/苦瓜.jpg",},
		{title:"说散就散",artist:"袁娅维",mp3:"/musicPlayer/mp3/袁娅维-说散就散.mp3",cover:"/musicPlayer/img/说散就散.jpg",},
		{title:"去年夏天",artist:"王大毛",mp3:"/musicPlayer/mp3/王大毛-去年夏天.mp3",cover:"/musicPlayer/img/去年夏天.jpg",},
		{title:"忆少年",artist:"王大毛",mp3:"/musicPlayer/mp3/王大毛-忆少年.mp3",cover:"/musicPlayer/img/忆少年.jpg",},
		{title:"千千阙歌",artist:"谭咏麟",mp3:"/musicPlayer/mp3/谭咏麟-千千阙歌.mp3",cover:"/musicPlayer/img/千千阙歌.jpg",},
		{title:"消愁",artist:"毛不易",mp3:"/musicPlayer/mp3/毛不易-消愁.mp3",cover:"/musicPlayer/img/消愁.jpg",},
		{title:"17岁",artist:"刘德华",mp3:"/musicPlayer/mp3/刘德华-17岁.mp3",cover:"/musicPlayer/img/17岁.jpg",},
		{title:"那些你很冒险的梦",artist:"林俊杰",mp3:"/musicPlayer/mp3/林俊杰-那些你很冒险的梦.mp3",cover:"/musicPlayer/img/那些你很冒险的梦.jpg",},
		{title:"水星记",artist:"郭顶",mp3:"/musicPlayer/mp3/郭顶-水星记.mp3",cover:"/musicPlayer/img/水星记.jpg",},
		{title:"飞云之下",artist:"韩红&林俊杰",mp3:"/musicPlayer/mp3/韩红&林俊杰-飞云之下.mp3",cover:"/musicPlayer/img/飞云之下.jpg",},
		{title:"慢慢喜欢你",artist:"李瑨瑶",mp3:"/musicPlayer/mp3/李瑨瑶-慢慢喜欢你.mp3",cover:"/musicPlayer/img/慢慢喜欢你.jpg",},
		{title:"备爱",artist:"周思涵",mp3:"/musicPlayer/mp3/周思涵-备爱.mp3",cover:"/musicPlayer/img/备爱.jpg",},
		{title:"等你下课(with 杨瑞代)",artist:"周杰伦",mp3:"/musicPlayer/mp3/周杰伦-等你下课(with 杨瑞代).mp3",cover:"/musicPlayer/img/等你下课(with 杨瑞代).jpg",},
		{title:"告白气球",artist:"周杰伦",mp3:"/musicPlayer/mp3/周杰伦-告白气球.mp3",cover:"/musicPlayer/img/告白气球.jpg",},
		{title:"Mojito",artist:"周杰伦",mp3:"/musicPlayer/mp3/周杰伦-Mojito.mp3",cover:"/musicPlayer/img/Mojito.jpg",},
		{title:"爱的飞行日记",artist:"周杰伦&杨瑞代",mp3:"/musicPlayer/mp3/周杰伦&杨瑞代-爱的飞行日记.mp3",cover:"/musicPlayer/img/爱的飞行日记.jpg",},
		{title:"情深深雨濛濛",artist:"杨胖雨",mp3:"/musicPlayer/mp3/杨胖雨-情深深雨濛濛.mp3",cover:"/musicPlayer/img/情深深雨濛濛.jpg",},
		{title:"听妈妈的话",artist:"周杰伦",mp3:"/musicPlayer/mp3/周杰伦-听妈妈的话.mp3",cover:"/musicPlayer/img/听妈妈的话.jpg",},
		{title:"孤独患者",artist:"陈奕迅",mp3:"/musicPlayer/mp3/陈奕迅-孤独患者.mp3",cover:"/musicPlayer/img/孤独患者.jpg",},
		{title:"Closer",artist:"The Chainsmokers&Halsey",mp3:"/musicPlayer/mp3/The Chainsmokers&Halsey-Closer(靠近).mp3",cover:"/musicPlayer/img/Closer.jpg",},
		{title:"不潮不用花钱",artist:"林俊杰",mp3:"/musicPlayer/mp3/林俊杰-不潮不用花钱.mp3",cover:"/musicPlayer/img/不潮不用花钱.jpg",},
		{title:"失忆",artist:"刘崇健",mp3:"/musicPlayer/mp3/刘崇健-失忆.mp3",cover:"/musicPlayer/img/失忆.jpg",},
	],
		isShowNotification = false,
		isInitMarquee = true,
		shuffleArray = [],
		shuffleIndex,
		autoClearTimer,
		autoShowTimer,
		isFirstPlay = localStorage.qplayer == undefined? true: false,
		isShuffle = localStorage.qplayer == undefined? false: localStorage.qplayer === 'true'? true: false;

	// Load playlist
	for (var i = 0; i < playlist.length; i++){
		var item = playlist[i];
		$('#playlist').append('<li class="lib" style="overflow:hidden;"><strong style="margin-left: 5px;">'+item.title+'</strong><span style="float: right;" class="artist">'+item.artist+'</span></li>');
		if (item.mp3 == "") {
			$('#playlist li').eq(i).css('color', '#ddd');
		}
	}

	var currentTrack = 0, audio, timeout;
	var shuffle_array = localStorage.qplayer_shuffle_array;

	if (isShuffle && shuffle_array != undefined && playlist.length === (shuffleArray=JSON.parse(shuffle_array)).length) {
		currentTrack = shuffleArray[0];
		shuffleIndex = 0;
	    $('#QPlayer .cover').attr('title', '点击关闭随机播放');
	} else {
		isShuffle = false;
	    $('#QPlayer .cover').attr('title', '点击开启随机播放');
	}

	//判断是否显示滚动条
	var totalHeight = 0;
	for (var i = 0; i < playlist.length; i++){
		totalHeight += ($('#playlist li').eq(i).height() + 6);
	}
	if (totalHeight > 360) {
		$('#playlist').css("overflow", "auto");
		if (isShuffle) {
			var temp = 0;
			for (var j = 0; j < currentTrack; j++) {
				temp += ($('#playlist li').eq(j).height() + 6);
			}
			$('#playlist').scrollTop(temp);
		}
	} 

	var play = function(){
		audio.play();
		if (isRotate) {
			$("#player .cover img").css("animation","9.8s linear 0s normal none infinite rotate");
		    $("#player .cover img").css("animation-play-state","running");
	    }
		$('.playback').addClass('playing');
		timeout = setInterval(updateProgress, 500);
		//超过显示栏运行跑马灯
		if(isExceedTag()) {
			if (isInitMarquee) {
				initMarquee();
				isInitMarquee = false;
			} else {
				$('.marquee').marquee('resume');
		    }
	    }
	}

	var pause = function(){
		audio.pause();
		$("#player .cover img").css("animation-play-state","paused");
		$('.playback').removeClass('playing');
		clearInterval(timeout);
		if(isExceedTag()) {
			$('.marquee').marquee('pause');
		}
	}

	// Update progress
	var setProgress = function(value){
		var currentSec = parseInt(value%60) < 10 ? '0' + parseInt(value%60) : parseInt(value%60),
			ratio = value / audio.duration * 100;

		$('.timer').html(parseInt(value/60)+':'+currentSec);
	}

	var updateProgress = function(){
		setProgress(audio.currentTime);
	}

	// Switch track
	var switchTrack = function(i){
		if (i < 0){
			track = currentTrack = playlist.length - 1;
		} else if (i >= playlist.length){
			track = currentTrack = 0;
		} else {
			track = i;
		}

		isInitMarquee = true;
		$('audio').remove();
		loadMusic(track);
		play();
	}

	// Shuffle
	var shufflePlay = function(i){
		if (i === 1) {
		//下一首
		    if (++shuffleIndex === shuffleArray.length) {
		    	shuffleIndex = 0;
		    }
		    currentTrack = shuffleArray[shuffleIndex];

		} else if (i === 0) {
		//上一首
		    if (--shuffleIndex < 0) {
		    	shuffleIndex = shuffleArray.length - 1;
		    }
		    currentTrack = shuffleArray[shuffleIndex];
		}
		switchTrack(currentTrack);
	}

	// Fire when track ended
	var ended = function(){
		pause();
		audio.currentTime = 0;
		if (isShuffle){
			shufflePlay(1);
		} else { 
			if (currentTrack < playlist.length) switchTrack(++currentTrack);
		}
		
	}

	var beforeLoad = function(){
		var endVal = this.seekable && this.seekable.length ? this.seekable.end(0) : 0;
	}

	// Fire when track loaded completely
	var afterLoad = function(){
		if (autoplay == true) play();
	}

	// Load track
	var loadMusic = function(i){
		var item = playlist[i];
		while (item.mp3 == "") {
	        showNotification('歌曲地址为空，已自动跳过');
			if (isShuffle) {
				if (++shuffleIndex === shuffleArray.length) {
			    	shuffleIndex = 0;
			    }
			    i = currentTrack = shuffleArray[shuffleIndex];
			} else {
				currentTrack = ++i;
			}
			item = playlist[i];
		}
		var newaudio = $('<audio>').html('<source src="'+item.mp3+'"><source src="'+item.ogg+'">').appendTo('#player');
		$('.cover').html('<img src="'+item.cover+'" alt="'+item.album+'">');
		$('.musicTag').html('<strong>'+item.title+'</strong><span> - </span><span class="artist">'+item.artist+'</span>');
		$('#playlist li').removeClass('playing').eq(i).addClass('playing');
		audio = newaudio[0];
		audio.addEventListener('progress', beforeLoad, false);
		audio.addEventListener('durationchange', beforeLoad, false);
		audio.addEventListener('canplay', afterLoad, false);
		audio.addEventListener('ended', ended, false);
	}

	loadMusic(currentTrack);

	$('.playback').on('click', function(){
		if ($(this).hasClass('playing')){
			pause();
		} else {
			play();
		}
	});

	$('.rewind').on('click', function(){
		if (isShuffle){
			shufflePlay(0);
		} else {
			switchTrack(--currentTrack);
		}
	});

	$('.fastforward').on('click', function(){
		if (isShuffle){
			shufflePlay(1);
		} else {
			switchTrack(++currentTrack);
		}
	});
	
	$('#playlist li').each(function(i){
		$(this).on('click', function(){
			if (isShuffle) {
				for (var j = 0; j < shuffleArray.length; j++) {
					if (shuffleArray[j] === i) {
						shuffleIndex = j;
						break;
					}
				}
			} else {
			    currentTrack = i;
			}
			switchTrack(i);
		});
	});

	$('#QPlayer .liebiao,#QPlayer .liebiao').on('click', function(){
		var pl = $('#playlist');
		if (pl.hasClass('go') === false) {
			pl.css({"max-height":"360px","transition":"max-height .5s ease"});		
			pl.css("border", "1px solid #dedede");
			pl.addClass('go');
		} else {
			pl.css({"max-height":"0px","transition":"max-height .5s ease"});
			pl.css("border", "0");
			pl.removeClass('go');
		}
	});		

	$("#QPlayer .ssBtn").on('click', function(){
		var mA = $("#QPlayer");
		if ($('.ssBtn .adf').hasClass('on') === false) {
			if (isFirstPlay) {
			    setTimeout("showTips('#player .cover','点击封面开启(关闭)随机播放', " + function(){setTimeout("showTips('#player .ctrl .musicTag','点击拖动标题栏快进(快退)')", 1000)} + ");", 500);
			    isFirstPlay = !isFirstPlay;
			    localStorage.qplayer = 'false';
			}
			mA.css("transform", "translateX(250px)");
		    $('.ssBtn .adf').addClass('on');
		} else {	
			mA.css("transform", "translateX(0px)");
            $('.ssBtn .adf').removeClass('on') 	
		}
	}); 

	$("#player .cover").on('click',function(){
		isShuffle = !isShuffle;
		if (isShuffle) {
	        $("#player .cover").attr("title","点击关闭随机播放");
	        showNotification('已开启随机播放');

			var temp = [];
			for (var i = 0; i < playlist.length; i++) {
				temp[i] = i;
			}
			shuffleArray = shuffle(temp);
			for (var j = 0; j < shuffleArray.length; j++) {
				if (shuffleArray[j] === currentTrack) {
					shuffleIndex = j;
					break;
				}
			}
			localStorage.qplayer_shuffle_array = JSON.stringify(shuffleArray);
		} else {
	        $("#player .cover").attr("title","点击开启随机播放");
	        showNotification('已关闭随机播放');
	        localStorage.removeItem('qplayer_shuffle_array');
		}
		localStorage.qplayer = isShuffle;
	});


    var startX, endX;
    $('#player .ctrl .musicTag').mousedown(function(event){
    	startX = event.screenX;
    }).mousemove(function(event){
    	//鼠标左键
    	if (event.which === 1) {
	    	endX = event.screenX;
	    	var seekRange = Math.round((endX - startX) / 678 * 100);
	    	audio.currentTime += seekRange;
	    	setProgress(audio.currentTime);
	    }
    });

    $('#player .ctrl .musicTag').bind('touchstart', function(event){
    	startX = event.originalEvent.targetTouches[0].screenX;
    }).bind('touchmove',function(event){
    	endX = event.originalEvent.targetTouches[0].screenX;
    	var seekRange = Math.round((endX - startX) / 678 * 100);
    	audio.currentTime += seekRange;
    	setProgress(audio.currentTime);
    });

})(jQuery);


function initMarquee(){
	$('.marquee').marquee({
	    //speed in milliseconds of the marquee
	    duration: 15000,
	    //gap in pixels between the tickers
	    gap: 50,
	    //time in milliseconds before the marquee will start animating
	    delayBeforeStart: 0,
	    //'left' or 'right'
	    direction: 'left',
	    //true or false - should the marquee be duplicated to show an effect of continues flow
	    duplicated: true
	});
}

//检测标题和作者信息总宽度是否超出播放器，超过则返回true开启跑马灯
function isExceedTag() {
	var isExceedTag = false;
	if ($('.musicTag strong').width() + $('.musicTag span').width() + $('.musicTag .artist').width() > $('.musicTag').width()) {
	    isExceedTag = true;
	}
	return isExceedTag;
}


function shuffle(array) {
    var m = array.length,
        t, i;
    // 如果还剩有元素…
    while (m) {
        // 随机选取一个元素…
        i = Math.floor(Math.random() * m--);
        // 与当前元素进行交换
        t = array[m];
        array[m] = array[i];
        array[i] = t;
    }
    return array;
}

function showNotification(info) {
	isShowNotification = true;
	//判断通知是否存在，存在就移除
    if ($('.qplayer-notification').length>0) {
    	$('.qplayer-notification').remove();
    	clearTimeout(autoClearTimer);
    	clearTimeout(autoShowTimer);
    }
	$('body').append('<div class="qplayer-notification animation-target"><span class="qplayer-notification-icon">i</span><span class="body" style="box-shadow: rgba(0, 0, 0, 0.0980392) 0px 0px 5px;"><span class="message"></span></span><a class="close" href="#" onclick="closeNotification();return false;">×</a><div style="clear: both"></div>');
	$('.qplayer-notification .message').text(info);
	//用width:auto来自动获取通知栏宽度
	var width = $('.qplayer-notification').css({"opacity":"0", "width":"auto"}).width() + 20;
	$('.qplayer-notification').css({"width":"50px","opacity":"1"});
	
	autoShowTimer = setTimeout(function(){
		$('.qplayer-notification').css({"width":width,"transition":"all .7s ease"});
		$('.qplayer-notification .close').delay(500).show(0);
	},1500);
	autoClearTimer = setTimeout("if ($('.qplayer-notification').length>0) {closeNotification()}",8000);
}


function closeNotification() {
	isShowNotification = false;
	$('.qplayer-notification').css({"width":"50px","transition":"all .7s ease"});
	$('.qplayer-notification .close').delay(500).hide(0);
	setTimeout(function(){
		if (!isShowNotification) {
			$('.qplayer-notification').css("opacity","0");
			$('.qplayer-notification-icon').css({"transform":"scale(0)","transition":"transform .5s ease"});
	    }
	},1000);
	setTimeout(function(){
		if (!isShowNotification) {
			$('.qplayer-notification').remove();
		}
	},1500);
    clearTimeout(autoClearTimer);
    clearTimeout(autoShowTimer);
}

/*
*div: 要在其上面显示tip的div
*info: tip内容
*func: 不再提示按钮的click绑定函数
*/
function showTips(div, info, func) {
	var box_height = 100;
	$('body').append('<div class="qplayer_tips"><span class="tips_arrow"></span><span class="info" style="display:none">' + info + '</span><button class="tips_button" onclick="removeTips()">不再提示</button></div>');
	$('.qplayer_tips').css({"top":$(div).offset().top-box_height-30-15, "left": $(div).offset().left-28});
	$('.qplayer_tips').css({"height":box_height,"transition":"all .5s ease-in-out"});
	$('.qplayer_tips .info').delay(500).fadeIn();
	$('.tips_arrow').css({"border-width":"15px","transition":"all .5s ease-in-out"});
	$('.tips_button').css({"height":"30px","transition":"all .5s ease-in-out"});
	if (func != undefined) {
		$('.tips_button').click(func);
	}
}

function removeTips() {
	$('.qplayer_tips .info').fadeOut();
	$('.qplayer_tips').css({"height":"0","transition":"all .5s ease-in-out"});
	$('.tips_arrow').css({"border-width":"0","transition":"all .5s ease-in-out"});
	$('.tips_button').css({"opacity":"0","transition":"all .2s ease-in-out"});
	setTimeout(function(){$('.qplayer_tips').remove()}, 500);
}