var http=require('http');

var urls=['www.qq.com','www.sohu.com','www.baidu.com'];

for(var i=0;i<urls.length;i++){
	fetchPage(urls[i]);
}

function fetchPage(url){
	var start=new Date();
	http.get({'host':url},function(res){
		console.log('Got respones from : '+url);
		console.log('Resquest time :'+(new Date()-start)+' ms');
	});
}