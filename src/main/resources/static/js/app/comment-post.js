var main = {
    init : function () {
        var _this = this;

        $('#btn-comment-save').on('click', function() {
            _this.save();
        });
    },

    save : function () {
        var diary_id = $("#diary-id").val()

        var data = {
            title: $('#comment-title').val(),
            content: $('#comment-content').val(),
            diaryId: diary_id
        };

        $.ajax({
            type: 'POST',
            url: '/api/comment/',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('Comment가 생성되었습니다.');
            window.location.href = '/diary/' + diary_id;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
};


main.init();