/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.82
 * Generated at: 2019-03-03 12:48:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class upload_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"static/bootstrap/js/jquery-1.8.3.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"static/bootstrap/js/jquery.min.js\"></script>\r\n");
      out.write("<title>文件上传测试页面</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<form id=\"myform\" method=\"post\">\r\n");
      out.write("\t\t附件： <input id=\"aa\" type=\"file\" name=\"record\" /> <input type=\"button\"\r\n");
      out.write("\t\t\tonclick=\"doUpload()\" value=\"提交\" />\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<h3>不通过表单上传文件</h3>\r\n");
      out.write("\r\n");
      out.write("\t\t附件:<input id=\"file\" type=\"file\" name=\"file\" />\r\n");
      out.write("\t\t<button id=\"upload\">上传</button>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(\"#upload\").click(function(){\r\n");
      out.write("    alert($(\"#file\").value);\r\n");
      out.write("\tif(document.getElementById(\"file\").value == null || document.getElementById(\"file\").value == \"\"){\r\n");
      out.write("        alert(\"请选择上传文件\");\r\n");
      out.write("        return\r\n");
      out.write("}\r\n");
      out.write("\tif($(\"#file\").value == null || $(\"#file\").value == \"\"){\r\n");
      out.write("        alert(\"请选择上传文件\");\r\n");
      out.write("        return\r\n");
      out.write("      } \r\n");
      out.write("\tvar formData = new FormData();\r\n");
      out.write("\tformData.append('file', $('#file')[0].files[0]);  \r\n");
      out.write("\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl: \"upload/fileupload\",\r\n");
      out.write("\t\ttype: \"POST\",\r\n");
      out.write("\t\tdata: formData,\r\n");
      out.write("\t\t/**\r\n");
      out.write("\t\t*必须false才会自动加上正确的Content-Type\r\n");
      out.write("\t\t*/\r\n");
      out.write("\t\tcontentType: false,\r\n");
      out.write("\t\t/**\r\n");
      out.write("\t\t* 必须false才会避开jQuery对 formdata 的默认处理\r\n");
      out.write("\t\t* XMLHttpRequest会对 formdata 进行正确的处理\r\n");
      out.write("\t\t*/\r\n");
      out.write("\t\tprocessData: false,\r\n");
      out.write("\t\tasync: false,  \r\n");
      out.write("        cache: false,  \r\n");
      out.write("        \r\n");
      out.write("\t\tsuccess: function (data) {\r\n");
      out.write("\t\t\talert(\"success\");\r\n");
      out.write("\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\terror: function (data) {\r\n");
      out.write("\t\t\talert(\"上传失败！\");\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\t\r\n");
      out.write("})\t\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function doUpload() { \r\n");
      out.write("\r\n");
      out.write("\tif(document.getElementById(\"aa\").value == null || document.getElementById(\"aa\").value == \"\"){\r\n");
      out.write("\t        alert(\"请选择上传文件\");\r\n");
      out.write("\t        return\r\n");
      out.write("\t}\r\n");
      out.write("    var formData = new FormData($( \"#myform\" )[0]);  \r\n");
      out.write("    $.ajax({  \r\n");
      out.write("         url: 'upload/fileupload' ,  \r\n");
      out.write("         type: 'POST',  \r\n");
      out.write("         data: formData,  \r\n");
      out.write("         async: false,  \r\n");
      out.write("         cache: false,  \r\n");
      out.write("         contentType: false,  \r\n");
      out.write("         processData: false,  \r\n");
      out.write("         success: function (returndata) {  \r\n");
      out.write("             alert(\"上传成功！！！\");  \r\n");
      out.write("         },  \r\n");
      out.write("         error: function (returndata) {  \r\n");
      out.write("             alert(\"上传失败\");  \r\n");
      out.write("         }  \r\n");
      out.write("    });  \r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
