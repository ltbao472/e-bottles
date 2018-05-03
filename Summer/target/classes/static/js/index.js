var index = {
	init: function(){
		var base = this;
		$('#btnGen').on('click', function(){
			if(!$('#planText').val()){
				$('#result').html('');
				return;
			}
			base.textChange($('#planText').val());
		});
	},
	textChange: function(text){
		$.ajax({
			type:'POST',
			url:'/api/md5',
			data:{data:text},
			success: function(result){
				$('#result').html(result);
			}
		});
	}
};

index.init();