<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<%@include file="header.jsp"%>
<script language="javascript" type="text/javascript" src="js/article.js"></script>
<body>
<!-- 主体 -->
<div class="placeholder-height"></div>
<div class="article-section-wrap">
    <div class="article-section" data-aid="197460">
    <div class="container" id="article197460">
        <div class="nrtj-wrap" id="nrtj-wrap197460"></div>
        <div class="wrap-left pull-left">
            <div class="article-wrap">
                <h1 class="t-h1">${article.title}</h1>
                <div class="article-author">
                <span class="author-name"></span>
                <div class="column-link-box">
                	<span class="article-time pull-left">${article.dataTime}</span>
					<!-- 当用户点击收藏时，发送请求到./collected -->
					<span class="article-share pull-left collected">
						<!-- 隐藏uId，aId，title -->
						<span id="uId" style="display: none">${uid}</span>
						<span id="aId" style="display: none">${article.aId}</span>
						<c:if test="${isCollect==null||isCollect==0}">
							<span class="article-share pull-left" id="collect">收藏</span>
						</c:if>
						<c:if test="${isCollect==1}">
							<span class="article-share pull-left" id="collect">已收藏</span>
						</c:if>
						<span id="collectSum">${status.collected}</span>
					</span>


					<!-- 当用户点赞时，发送请求到./like -->
                    <i class="icon icon-like like"></i><span class="like"><a href="./like">${status.like}</a></span>
                    <a href="#" class="column-link" target="_blank"></a>
                </div>                     
            </div>
<!--管理员按钮-->
            <div class="article-manage-bar" id="article-manage-bar197460"></div>

            <div id="article_content197460" class="article-content-wrap">
                 ${article.context}
            </div>
			
                    <!--管理员底部按钮-->
             <div class="article-manage-bar article-bottom-manage-bar" id="article-bottom-manage-bar197460"></div>
			 
              <!--公共评论-->
              <div class="pl-wrap" id="pl-wrap-article197460" name="pl-wrap-article">
                   <div id="pl-wrap197460" name="pl-wrap"></div>
                   <div class="pl-list-wrap">
                        <div class="pl-loading hide"><img src="/static_2015/img/pl-loading.gif"></div>
                        <a href="javascript:void(0)" class="span-mark-author active js-default-new-pl" data-type="agree">默认评论</a>
                        <i class="icon icon-line-pl"></i>
                        <a href="javascript:void(0)" class="span-mark-author new js-default-new-pl" data-type="dateline">最新评论</a>

					   <!-- 用户评论区 -->
                       <!-- 数据有：用户头像 用户名 评价时间 评价内容 点赞数 踩数 -->

					   <div class="pl-box-wrap">
                			<div class="pl-box-top">
								<!--用户头像 用户名 评价时间-->
            					<div class="author-info">
                					<div class="author-face"><img src="https://img.huxiucdn.com/auth/data/avatar/001/54/60/18_1479690318.jpg?|imageMogr2/strip/interlace/1/quality/85/format/jpg"></div>
                					<span class="author-name"><a href="#">请叫我__宝器</a><a href="/vip" target="_blank"></a></span>
                					<span class="time">6天前</span>
            					</div>
								<!-- 评论内容 -->
            					<div class="pl-content">三个这么浅显的例子和分析就能让作者得出结论，这"一叶知秋"的本事我也是服的。</div>
                    		</div>

        					<div class="pl-box-btm">
                            	<div class="article-type pull-right">
									<!-- 点赞数 踩数 -->
                					<ul>
                    					<li class="js-icon-like" data-type="like"><i class="icon icon-like "></i><span class="like">2</span></li>
                    					<li class="js-no-icon-like" data-type="no-like"><i class="icon icon-no-like "></i><span class="like">1</span></li>
                					</ul>
            					</div>
								<!-- 评论 -->
            					<div class="btn-dp transition js-add-dp-box"><i class="icon icon-dp"></i>我要点评</div>
            					<div class="pl-form-box dp-article-box">
                					<textarea class="form-control" placeholder="客官，8个字起评，不讲价哟"></textarea>
                					<button class="btn btn-article js-article-dp">发表</button>
            					</div>
        					</div>
    					</div>



    					<div class="pl-box-wrap  ">
                			<div class="pl-box-top">
								<!--用户头像 用户名 评价时间-->
            					<div class="author-info">
                					<div class="author-face"><img src="https://img.huxiucdn.com/auth/data/avatar/001/68/30/86_1496144520.jpg?|imageMogr2/strip/interlace/1/quality/85/format/jpg"></div>
									<span class="author-name"><a href="#">请叫我__宝器</a><a href="/vip" target="_blank"></a></span>
									<span class="time">6天前</span>
            					</div>
								<!-- 评论内容 -->
            					<div class="pl-content">小罐茶，记得是非常非常贵</div>
								<!-- 回复 -->
                            	<div class="dp-box">
                                    <div class="dl-user dl-user-list  " data-type="dl-user" style="display:block">
										<!-- 回复者头像 -->
                            			<ul>
                                            <li class="del-pl108924"><a href="#" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/3.jpg?|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a></li>
                                        </ul>
                                       <!-- 回复内容 -->
                                		<div class="one-pl-content one-pl-content-box">
                                    		<div class="pull-right time">6天前</div>
												 <p class="content">
                                        			<span class="name">寂地_</span>
                                        			<span class="author-content">@lingboxiu 马云家有，对我尔等来说确实是灰常贵</span>
                                    			 </p>
												<div class="btn-dp transition js-add-dp-box"><i class="icon icon-dp"></i>回复</div>
												<div class="pl-form-box dp-article-box">
													<textarea class="form-control" placeholder="客官，8个字起评，不讲价哟"></textarea>
													<button class="btn btn-article js-article-dp">发表</button>
												</div>
                                			</div>
                                        </div>
                    			</div>
								<div class="pl-box-btm">
									<div class="article-type pull-right">
										<!-- 点赞数 踩数 -->
										<ul>
											<li class="js-icon-like" data-type="like"><i class="icon icon-like "></i><span class="like">2</span></li>
											<li class="js-no-icon-like" data-type="no-like"><i class="icon icon-no-like "></i><span class="like">1</span></li>
										</ul>
									</div>
									<!-- 评论 -->
									<div class="btn-dp transition js-add-dp-box"><i class="icon icon-dp"></i>我要点评</div>
									<div class="pl-form-box dp-article-box">
										<textarea class="form-control" placeholder="客官，8个字起评，不讲价哟"></textarea>
										<button class="btn btn-article js-article-dp">发表</button>
									</div>
								</div>
							</div>
						</div>

				   </div>
              </div>
                    <!--相关文章位置-->
              <div id="related-article-wrap197460"></div>
		</div>
     </div>

		<!-- 该文章作者信息 -->
     <div class="wrap-right pull-right">
     	<div class="box-author-info">
			<!-- 作者头像 -->
        	<div class="author-face">
                <!-- 作者头像 -->
        		<a href="#" target="_blank"><img src="./images/3172135363.jpg"></a>
    		</div>
			<br>
    		<div class="author-one">昵称：${usermessage.userName}</div>
    		<div class="author-one">公司：${usermessage.company}</div>
			<c:if test="${usermessage.mailbox!=null}">
				<div class="author-one">邮箱：${usermessage.mailbox}</div>
			</c:if>
			<!-- 一共发表的文章 -->
    		<div class="author-article-pl">
        		<ul>
            		<li><a href="./allNewsOfAuthor?author=${usermessage.userName}" target="_blank">共发表的文章：${newSum}</a></li>
        		</ul>
    		</div>
			<!-- 最近发表的一篇文章 -->
        	<div class="author-next-article">
        		<div class="author-one c2">最近文章</div>
        			<a href="./article?aId=${lastArticle.aId}" target="_blank">${lastArticle.title}</a>
    			</div>
        	</div>


		 <!-- 相关新闻，显示5条 -->
		<div class="placeholder"></div>
    		<div class="box-moder hot-article">
        		<h3>相关文章</h3>
        		<span class="span-mark"></span>
        		<ul>
                    <li>                	
                    	<a href="#" class="transition" target="_blank">3年了，我们的内容消费发生了什么变化？</a>
                	</li>
                    <li>
                    	<a href="#" class="transition" target="_blank">顺丰，菜鸟，令狐冲，岳不群</a>
               		</li>
                    <li>
                    	<a href="#" class="transition" target="_blank">3年了，我们的内容消费发生了什么变化？</a>
                	</li>
                    <li>
                    	<a href="#" class="transition" target="_blank">顺丰，菜鸟，令狐冲，岳不群</a>
               		</li>
                    <li>
                    	<a href="#" class="transition" target="_blank">3年了，我们的内容消费发生了什么变化？</a>
                	</li>
                </ul>
    		</div>
        </div>
    </div>
</div>
<div class="article-section article-section-last"></div>
</div>


<%@include file="footer.jsp"%>
<script language="javascript" type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script>
$(document).ready(function() {
     $(".dp-article-box").fadeOut(0);
     $(".js-add-dp-box").click(function() {
          $(".dp-article-box").not($(this).next()).slideUp('fast');
          $(this).next().slideToggle(400);
     });
});
</script>
<script type="text/javascript" src="js/mouse.js"></script>
</body>
</html>