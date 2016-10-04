var http=require('http');
//var mysql=require('mysql');

http.createServer(function(req,res){
	//res.writeHead('200',{'Content-type':'text/plain'});
	res.writeHead('200',{'Content-type':'text/html'});
	//res.write('<h1>hello world</h1>');
	res.end('<h1>laoshan</h1>');
}).listen(3000);

console.log('server is listening 3000 port');