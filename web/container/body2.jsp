<%-- 
    Document   : body2
    Created on : Dec 13, 2018, 9:24:30 AM
    Author     : EMDES
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
</div>
<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="../assets/vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../assets/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../assets/vendor/metisMenu/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src="../assets/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="../assets/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="../assets/vendor/datatables-responsive/dataTables.responsive.js"></script>
<!-- date-range-picker -->
<script src="../assets/vendor/bower_components/moment/min/moment.min.js"></script>
<script src="../assets/vendor/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- bootstrap datepicker -->
<script src="../assets/vendor/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="../assets/dist/js/sb-admin-2.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function () {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
</script>
<script>
    $(function () {
//Initialize Select2 Elements
        $('.select2').select2()

//Datemask dd/mm/yyyy
        $('#datemask').inputmask('dd/mm/yyyy', {'placeholder': 'dd/mm/yyyy'})
//Datemask2 mm/dd/yyyy
        $('#datemask2').inputmask('mm/dd/yyyy', {'placeholder': 'mm/dd/yyyy'})
//Date picker
        $('#startdate').datepicker({
            autoclose: true
        })
//Date picker
        $('#enddate').datepicker({
            autoclose: true
        })

//iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        })
//Red color scheme for iCheck
        $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
            checkboxClass: 'icheckbox_minimal-red',
            radioClass: 'iradio_minimal-red'
        })
//Flat red color scheme for iCheck
        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
            checkboxClass: 'icheckbox_flat-green',
            radioClass: 'iradio_flat-green'
        })

//Colorpicker
        $('.my-colorpicker1').colorpicker()
//color picker with addon
        $('.my-colorpicker2').colorpicker()

//Timepicker
        $('.timepicker').timepicker({
            showInputs: false
        })
    })
</script>

