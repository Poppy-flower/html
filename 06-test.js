//读取1.txt 然后停两秒再结束
var fs=require('fs');
fs.readFile('1.txt','utf-8',function(err,data){
	if(err){
		console.log(err);
	}else{
		getData(data);
	}
});

console.log('end');

function getData(data){
	setTimeout(returnData(data),2000);
}

function returnData(data){
	console.log(data);
}