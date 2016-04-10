<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="modal fade bs-example-modal-sm" id="alert_id" role="dialog"
	aria-labelledby="gridSystemModalLabel">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="gridSystemModalLabel">qiuk 提示</h4>
			</div>
			<div class="modal-body" style="text-align: center;">
				<span id="message_id" style="color: green;">${message}</span>
				<span id="error_id" style="color: red;">${error}</span>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function Aerror(error) {
		$("#error_id").html(error);
		$("#alert_id").modal("show");
	}

	function Amessage(message) {
		$("#message_id").text(message);
		$("#alert_id").modal("show");
	}
</script>