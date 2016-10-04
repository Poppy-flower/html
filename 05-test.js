//同步读取
var fs=require('fs');
//var data=fs.readFileSync('1.txt','utf-8');
var data=fs.readFileSync('1.txt');
console.log(data);
console.log('end');

//异步读取
var data=fs.readFile('1.txt','utf-8',function(err,data){
	if(err){
		console.log(err);
	}else{
		console.log(data);
	}
});

console.log('end');