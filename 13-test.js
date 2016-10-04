//文件处理
var BASE_DIR=__dirname;
var fs=require('fs');

fs.chmod(BASE_DIR+'/2.txt','777',function(err){
	if(err){
		throw err;
	}else{
		console.log('vvvv');
	}
})

/*
fs.rename(BASE_DIR+'/1.txt',BASE_DIR+'/2.txt',function(err){
	if(err){
		throw err;
	}else{
		console.log('success');
	}
});*/

//fs.chmod   ugo  user  group other 777