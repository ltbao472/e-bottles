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
			contentType: "application/json",
			dataType : 'json',
			data:JSON.stringify({data:text}),
			success: function(result){
				$('#result').html(result.data);
			}
		});
	}
};

index.init();