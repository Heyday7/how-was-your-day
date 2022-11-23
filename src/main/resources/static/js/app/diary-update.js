var main = {
    init : function () {
        var _this = this;

        $('#btn-update').on('click', function() {
            _this.update();
        });
    },

    update : function () {
        var diary_id = $("span").data("diary-id");
        var actionCnt = $('input[name="comment[]"]').length;
        var actions = new Array(actionCnt);
        for (var i =0; i < actionCnt; i++) {
            var action = {
                comment: $('input[name="comment[]"]')[i].value,
                type: $('select[name="type[]"]')[i].value
            }
            actions[i] = action
        };

        var data = {
            title: $('#title').val(),
            body: $('#body').val(),
            actions: actions,
            isPrivate: $('#is-private').is(":checked")
        };

        $.ajax({
            type: 'PUT',
            url: '/api/diaries/' + diary_id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('Diary가 수정되었습니다.');
            window.location.href = '/diary/' + diary_id;
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
};



main.init();