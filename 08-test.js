function havelunch(food,drink,callback){
	console.log('Having lunch of '+food+','+drink);

	if(callback && typeof(callback) ==='function'){
		//callback();
		//console.log(123);

		
		setTimeout(function(){
			callback();
		},5000);

	}
}



havelunch('toast','coffee',function(){
	console.log('finish lunch');
});

console.log('end');