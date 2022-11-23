var main = {
    init : function () {
        var _this = this;

        var session_id = $("span").data("user-id");
        var diary_id = $("span").data("diary-id");

        var comments_length = $('input[name="comment-id-and-user-id[]"]').length;

        var html = `
            <button type="button" id="btn-comment-start-update">수정</button>
            <button type="button" id="btn-comment-delete">삭제</button>
        `

        for (var i=0; i < comments_length; i++) {
            var idArray = $('input[name="comment-id-and-user-id[]"]')[i].value.split(',')
            if (idArray[1] == session_id) {
                $('#comment-'+idArray[0]).append(html)
            }
        }

        $(document).ready(function () {
            $(document).on('click', "button[id='btn-comment-start-update']" ,function() {
                alert("start-update")
            });
            $(document).on('click', "button[id='btn-comment-delete']" ,function() {
                var comment_id = $(this).parent().data("comment-id")
                _this.delete(comment_id)
            });
        });
    },

    update : function (comment_id) {

    },

    delete : function (comment_id) {
        $.ajax({
            type: 'DELETE',
            url: '/api/comment/' + comment_id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
        }).done(function () {
            alert('Comment가 삭제되었습니다.');
            window.location.href = $(location).attr('href');
        }).fail(function (error) {
            alert(JSON.stringify(error));
        })
    },
};


main.init();