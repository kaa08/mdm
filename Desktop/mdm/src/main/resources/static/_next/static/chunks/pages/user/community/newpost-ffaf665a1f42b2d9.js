(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[7217],{646:function(e,t,n){(window.__NEXT_P=window.__NEXT_P||[]).push(["/user/community/newpost",function(){return n(1067)}])},1067:function(e,t,n){"use strict";n.r(t),n.d(t,{default:function(){return x}});var s=n(5893),o=n(7294),a=n(4793),l=n.n(a),i=n(1163),r=n(630),c=n(2480),_=n.n(c),u=n(9417),p=n(8901);function d(e){let{onFileUpload:t}=e,[n,a]=(0,o.useState)(""),[l,i]=(0,o.useState)(null),[r,c]=(0,o.useState)(null),[d,x]=(0,o.useState)(!1),[h,m]=(0,o.useState)(),w=async()=>{let e=new FormData;e.append("file",l),t(e)},{getRootProps:f,getInputProps:j,isDragActive:b}=(0,p.uI)({accept:"video/*,image/*",onDrop:e=>{x(e=>!e);let t=e[0];c(URL.createObjectURL(t)),i(t),a(t.name)},noKeyboard:!0});return(0,s.jsx)(s.Fragment,{children:d?(0,s.jsxs)(s.Fragment,{children:[(0,s.jsx)("div",{className:_().file_box,children:(0,s.jsx)("p",{children:n})}),(0,s.jsx)(u.Z,{onClick:w,children:"파일 업로드"})]}):(0,s.jsx)(u.Z,{children:(0,s.jsx)("div",{children:(0,s.jsxs)("div",{...f(),children:[(0,s.jsx)("input",{...j()}),(0,s.jsx)("p",{children:"파일 선택"})]})})})})}function x(){let e=(0,i.useRouter)(),[t,n]=(0,o.useState)(),[a,c]=(0,o.useState)(null),[_,u]=(0,o.useState)({title:"",content:""});(0,o.useEffect)(()=>{n(localStorage.getItem("loginToken")),console.log(t)},[t]);let p=e=>{u({..._,[e.target.name]:e.target.value})},x=async n=>{if(""===_.title||""===_.content){alert("제목과 내용을 입력해주세요.");return}n.preventDefault();let s=await (0,r.r4)(_,t);s?(a&&await (0,r.Tk)(a,t,s.data.boardId),alert("새 글이 게시되었습니다."),e.push("/user/community"),console.log(_)):console.error("에러")};return(0,s.jsxs)("form",{onSubmit:x,className:l().wrapper,children:[(0,s.jsxs)("div",{className:l().container,children:[(0,s.jsx)("div",{className:l().box,children:(0,s.jsx)("h2",{children:"글 작성"})}),(0,s.jsx)(d,{onFileUpload:e=>{c(e)}}),(0,s.jsxs)("div",{className:l().content_box,children:[(0,s.jsxs)("div",{className:l().title,children:[(0,s.jsx)("span",{children:"제목: "}),(0,s.jsx)("textarea",{name:"title",onChange:p,className:l().title_post,value:_.title})]}),(0,s.jsx)("textarea",{name:"content",className:l().content,onChange:p,value:_.content})]})]}),(0,s.jsx)("div",{className:l().new_post,children:(0,s.jsx)("button",{type:"submit",className:l().button,children:"글쓰기"})})]})}},4793:function(e){e.exports={wrapper:"newpost_wrapper__aNPrN",container:"newpost_container__OVTxl",box:"newpost_box__28mNv",search_bar:"newpost_search_bar__vnFYl",paging:"newpost_paging__Dk2W3",new_post:"newpost_new_post__dWieZ",content_box:"newpost_content_box__2mp9k",title:"newpost_title__iJD2U",title_post:"newpost_title_post__BNoiA",content:"newpost_content__haBu1",like:"newpost_like__FdfuA",button:"newpost_button__oXHqG"}},2480:function(e){e.exports={file_box:"ImageSelect_file_box__tMoL6"}}},function(e){e.O(0,[8901,2888,9774,179],function(){return e(e.s=646)}),_N_E=e.O()}]);