package indi.orange1438.managementsystem.dto;

import com.github.pagehelper.PageInfo;

/**
 * 分页DTO
 * 基本属性和com.github.pagehelper.PageInfo一致
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/04/10 13:31
 */
public class PageDTO {
    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //最终页面显示的底部翻页导航，详细见：getPageStr();
    private String pageStr;

    public PageDTO(PageInfo pageInfo) {
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.total = pageInfo.getTotal();
        this.pages = pageInfo.getPages();
    }

    public PageDTO(int pageNum, int pageSize, long total, int pages) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.pages = pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageStr() {
        StringBuffer sb = new StringBuffer();
        if (total > 0) {
            sb.append("	<ul>\n");
            sb.append("	<li><a>共<font color=red>" + total + "</font>条</a></li>\n");
            sb.append("	<li><input type=\"number\" value=\"\" id=\"toGoPage\" style=\"width:50px;text-align:center;float:left\" placeholder=\"页码\"/></li>\n");
            sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"toTZ();\"  class=\"btn btn-mini btn-success\">跳转</a></li>\n");

            if (pageNum == 1) {
                sb.append("	<li><a>首页</a></li>\n");
                sb.append("	<li><a>上页</a></li>\n");
            } else {
                sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage(1)\">首页</a></li>\n");
                sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage(" + (pageNum - 1) + ")\">上页</a></li>\n");
            }
            int showTag = 5;//分页标签显示数量
            int startTag = 1;
            if (pageNum > showTag) {
                startTag = pageNum - 1;
            }
            int endTag = startTag + showTag - 1;
            for (int i = startTag; i <= pages && i <= endTag; i++) {
                if (pageNum == i) {
                    sb.append("<li><a><font color='#808080'>" + i + "</font></a></li>\n");
                } else {
                    sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage(" + i + ")\">" + i + "</a></li>\n");
                }
            }
            if (pageNum == pages) {
                sb.append("	<li><a>下页</a></li>\n");
                sb.append("	<li><a>尾页</a></li>\n");
            } else {
                sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage(" + (pageNum + 1) + ")\">下页</a></li>\n");
                sb.append("	<li style=\"cursor:pointer;\"><a onclick=\"nextPage(" + pages + ")\">尾页</a></li>\n");
            }
            sb.append("	<li><a>第" + pageNum + "页</a></li>\n");
            sb.append("	<li><a>共" + pages + "页</a></li>\n");


            sb.append("	<li><select title='显示条数' style=\"width:55px;float:left;\" onchange=\"changeCount(this.value)\">\n");
            sb.append("	<option value='" + pageSize + "'>" + pageSize + "</option>\n");
            sb.append("	<option value='10'>10</option>\n");
            sb.append("	<option value='20'>20</option>\n");
            sb.append("	<option value='30'>30</option>\n");
            sb.append("	<option value='40'>40</option>\n");
            sb.append("	<option value='50'>50</option>\n");
            sb.append("	<option value='60'>60</option>\n");
            sb.append("	<option value='70'>70</option>\n");
            sb.append("	<option value='80'>80</option>\n");
            sb.append("	<option value='90'>90</option>\n");
            sb.append("	<option value='100'>100</option>\n");
            sb.append("	</select>\n");
            sb.append("	</li>\n");
            sb.append("</ul>\n");


            sb.append("<script type=\"text/javascript\">\n");

            //换页函数
            sb.append("function nextPage(page){");
            sb.append(" top.jzts();");
            sb.append("	if(true && document.forms[0]){\n");
            sb.append("		var url = document.forms[0].getAttribute(\"action\");\n");
            sb.append("		if(url.indexOf('?')>-1){url += \"&pageNum=\";}\n");
            sb.append("		else{url += \"?pageNum=\";}\n");
            sb.append("		url = url + page + \"&pageSize=" + pageSize + "\";\n");
            sb.append("		document.forms[0].action = url;\n");
            sb.append("		document.forms[0].submit();\n");
            sb.append("	}else{\n");
            sb.append("		var url = document.location+'';\n");
            sb.append("		if(url.indexOf('?')>-1){\n");
            sb.append("			if(url.indexOf('pageNum')>-1){\n");
            sb.append("				var reg = /pageNum=\\d*/g;\n");
            sb.append("				url = url.replace(reg,'pageNum=');\n");
            sb.append("			}else{\n");
            sb.append("				url += \"&pageNum=\";\n");
            sb.append("			}\n");
            sb.append("		}else{url += \"?pageNum=\";}\n");
            sb.append("		url = url + page + \"&pageSize=" + pageSize + "\";\n");
            sb.append("		document.location = url;\n");
            sb.append("	}\n");
            sb.append("}\n");

            //调整每页显示条数
            sb.append("function changeCount(value){");
            sb.append(" top.jzts();");
            sb.append("	if(true && document.forms[0]){\n");
            sb.append("		var url = document.forms[0].getAttribute(\"action\");\n");
            sb.append("		if(url.indexOf('?')>-1){url += \"&pageNum=\";}\n");
            sb.append("		else{url += \"?pageNum=\";}\n");
            sb.append("		url = url + \"1&pageSize=\"+value;\n");
            sb.append("		document.forms[0].action = url;\n");
            sb.append("		document.forms[0].submit();\n");
            sb.append("	}else{\n");
            sb.append("		var url = document.location+'';\n");
            sb.append("		if(url.indexOf('?')>-1){\n");
            sb.append("			if(url.indexOf('pageNum')>-1){\n");
            sb.append("				var reg = /pageNum=\\d*/g;\n");
            sb.append("				url = url.replace(reg,'pageNum=');\n");
            sb.append("			}else{\n");
            sb.append("				url += \"1&pageNum=\";\n");
            sb.append("			}\n");
            sb.append("		}else{url += \"?pageNum=\";}\n");
            sb.append("		url = url + \"&pageSize=\"+value;\n");
            sb.append("		document.location = url;\n");
            sb.append("	}\n");
            sb.append("}\n");

            //跳转函数
            sb.append("function toTZ(){");
            sb.append("var toPaggeVlue = document.getElementById(\"toGoPage\").value;");
            sb.append("if(toPaggeVlue == ''){document.getElementById(\"toGoPage\").value=1;return;}");
            sb.append("if(isNaN(Number(toPaggeVlue))){document.getElementById(\"toGoPage\").value=1;return;}");
            sb.append("nextPage(toPaggeVlue);");
            sb.append("}\n");
            sb.append("</script>\n");
        }
        pageStr = sb.toString();
        return pageStr;
    }
}
