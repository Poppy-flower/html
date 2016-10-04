//加载静态html文件
var http=require('http');
var url=require('url');
var dns=require('dns');
var fs=require('fs');
var querystring=require('querystring');

http.createServer(function(req,res){
	res.writeHead('200',{'Content-type':'text/html'});
	//console.log(url.parse('index.html'));
	//console.log(__dirname);
	//node1/module
	
	var readPath=__dirname+'/module/'+url.parse('index.html').pathname;
	var indexPage=fs.readFileSync(readPath);
	res.end(indexPage);
}).listen(4000);

console.log('server is listening port 4000');



/*
http url dns fs querystring

index.html--->加载到内存--->utf-8编码后的buffer--->打成数据包放入包体
---->返回给浏览器

name=laoshan  {'name':'laoshan'}*/