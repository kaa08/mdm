(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[2443],{946:function(t,n,e){(window.__NEXT_P=window.__NEXT_P||[]).push(["/user/customercenter",function(){return e(5587)}])},5651:function(t,n,e){"use strict";e.d(n,{AD:function(){return S},Aw:function(){return j},C3:function(){return x},Cx:function(){return W},Fl:function(){return o},GG:function(){return h},HH:function(){return J},HS:function(){return Z},JQ:function(){return B},JS:function(){return Q},K9:function(){return H},Mk:function(){return P},Mn:function(){return I},NH:function(){return E},NU:function(){return a},O1:function(){return f},OD:function(){return F},OR:function(){return O},Oz:function(){return q},Pk:function(){return d},QC:function(){return N},SQ:function(){return v},Sf:function(){return R},TD:function(){return A},Tk:function(){return u},Tr:function(){return p},XB:function(){return r},_I:function(){return L},bt:function(){return T},dg:function(){return g},eG:function(){return y},fB:function(){return _},fu:function(){return k},i1:function(){return l},kZ:function(){return m},mF:function(){return C},mR:function(){return M},oO:function(){return D},pI:function(){return w},ph:function(){return z},r4:function(){return s},s6:function(){return i},wh:function(){return b},zt:function(){return G}});var c=e(5121);async function r(t){try{return(await c.Z.post("http://ceprj.gachon.ac.kr:60011/user/login",t)).data.token}catch(t){alert("아이디와 비밀번호를 확인해주세요"),console.log(t)}}async function a(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/user/update",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n.data}catch(t){console.log(t)}}async function o(t){try{await c.Z.post("http://ceprj.gachon.ac.kr:60011/user/register",t)}catch(t){console.log(t)}}async function i(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/user/checkId?email=".concat(t));return console.log(n),alert("사용할 수 있는 이메일입니다."),200}catch(t){alert("사용할 수 없는 이메일입니다.")}}async function s(t,n){try{return await c.Z.post("http://ceprj.gachon.ac.kr:60011/board/write",t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){return console.log(t),!1}}async function u(t,n,e){try{await c.Z.post("http://ceprj.gachon.ac.kr:60011/board/".concat(e,"/file/upload"),t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){return console.log(t),!1}}async function l(t,n,e){try{return await c.Z.patch("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/update"),n,{headers:{Authorization:"Bearer ".concat(e)}}),!0}catch(t){return console.log(t),!1}}async function h(){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/board/list")}catch(t){console.log(t)}}async function p(t){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/board/".concat(t))}catch(t){console.log(t)}}async function d(t){try{await c.Z.delete("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/delete"))}catch(t){console.log(t)}}async function g(t){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/board/search?title=".concat(t,"&content=a&writerName=a"))}catch(t){console.log(t)}}async function f(t){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/list"))}catch(t){console.log(t)}}async function y(t,n,e){try{return await c.Z.post("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/write"),n,{headers:{Authorization:"Bearer ".concat(e)}})}catch(t){console.log(t)}}async function m(t,n,e){try{return await c.Z.delete("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/delete/").concat(n),{headers:{Authorization:"Bearer ".concat(e)}})}catch(t){console.log(t)}}async function j(t,n,e,r){try{return await c.Z.patch("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/update/").concat(n),e,{headers:{Authorization:"Bearer ".concat(r)}}),!0}catch(t){return console.log(t),!1}}async function _(){try{let t=await c.Z.get("http://ceprj.gachon.ac.kr:60011/inquiry/list");return console.log(t),t}catch(t){console.log(t)}}async function w(t,n){try{return await c.Z.post("http://ceprj.gachon.ac.kr:60011/inquiry/write",t,{headers:{Authorization:"Bearer ".concat(n)}}),!0}catch(t){return console.log(t),!1}}async function k(t,n){try{let e=await c.Z.get("http://ceprj.gachon.ac.kr:60011/inquiry/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}});return console.log(e),e}catch(t){console.log(t)}}async function Z(){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/admin/user/list")}catch(t){console.log(t)}}async function x(t,n){try{await c.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/user/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function A(){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/admin/board/list")}catch(t){console.log(t)}}async function q(t,n){try{let e=await c.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/board/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}});console.log(e)}catch(t){console.log(t)}}async function B(){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/admin/inquiry/list")}catch(t){console.log(t)}}async function z(t,n){try{return await c.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/inquiry/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function b(t,n,e){try{let r=await c.Z.patch("http://ceprj.gachon.ac.kr:60011/admin/inquiry/".concat(t,"/answer"),n,{headers:{Authorization:"Bearer ".concat(e)}});console.log(r)}catch(t){console.log(t)}}async function v(t,n){try{await c.Z.patch("http://ceprj.gachon.ac.kr:60011/mypage/user/update",t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function N(t){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/board/list",{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function C(t){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/comment/list",{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function I(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/inquiry/list",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n}catch(t){console.log(t)}}async function S(t,n){try{await c.Z.delete("http://ceprj.gachon.ac.kr:60011/mypage/board/list/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function L(t,n){try{await c.Z.delete("http://ceprj.gachon.ac.kr:60011/mypage/comment/list/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function O(t,n){try{await c.Z.delete("http://ceprj.gachon.ac.kr:60011/mypage/user/update/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function P(t,n){try{let e=await c.Z.post("http://61.79.137.116:5000/detect",t,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer ".concat(n)}});return console.log(e),e}catch(t){console.error("업로드 에러:",t)}}async function F(t,n,e){try{t.append("ratio",JSON.stringify({ratio:n}));let r=await c.Z.post("http://ceprj.gachon.ac.kr:60011/history/upload",t,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer ".concat(e)}});return console.log(r),r}catch(t){console.error("업로드 에러:",t)}}async function T(t,n){try{let e=await c.Z.get("http://ceprj.gachon.ac.kr:60011/history/download?historyId=".concat(t),{headers:{Authorization:"Bearer ".concat(n)},responseType:"blob"});return console.log(e),e.data}catch(t){console.error("업로드 에러:",t)}}async function E(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/admin/notice/list",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n}catch(t){console.log(t)}}async function G(t,n){try{let e=await c.Z.post("http://ceprj.gachon.ac.kr:60011/admin/notice/write",t,{headers:{Authorization:"Bearer ".concat(n)}});return console.log(e),e}catch(t){console.error("업로드 에러:",t)}}async function Q(t,n){try{await c.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/notice/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function R(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/history/list",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n}catch(t){console.log(t)}}async function D(){try{let t=await c.Z.get("http://ceprj.gachon.ac.kr:60011/review/list");return console.log(t),t}catch(t){console.error("업로드 에러:",t)}}async function H(t,n){try{let e=await c.Z.post("http://ceprj.gachon.ac.kr:60011/review/write",t,{headers:{Authorization:"Bearer ".concat(n)}});return console.log(e),e}catch(t){console.error("업로드 에러:",t)}}async function J(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/review/".concat(t));return console.log(n),n}catch(t){console.error("업로드 에러:",t)}}async function M(t,n){try{await c.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/review/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function W(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/review/list",{Authorization:"Bearer ".concat(t)});return console.log(n),n}catch(t){console.error("업로드 에러:",t)}}},5587:function(t,n,e){"use strict";e.r(n),e.d(n,{default:function(){return A}});var c=e(5893),r=e(8804),a=e.n(r),o=e(7294),i=e(5651),s=e(1163),u=e(5007),l=e(991),h=e.n(l);function p(t){let{title:n,content:e}=t,[r,a]=(0,o.useState)(!1);return(0,c.jsxs)("div",{className:h().container,onClick:()=>{a(t=>!t)},children:[(0,c.jsxs)("div",{className:h().title,children:["질문: ",n]}),r&&(0,c.jsxs)("div",{className:h().answer,children:["답변:",(0,c.jsx)("div",{className:h().content,children:e})]})]})}var d=e(115),g=e(3774),f=e.n(g);function y(t){let{InquiryList:n}=t,e=(0,s.useRouter)(),r=t=>{e.push("/user/customercenter/inquiryDetail/".concat(t))};return(0,c.jsx)(c.Fragment,{children:n&&n.map(t=>(0,c.jsxs)("div",{onClick:r.bind(null,t.inquiryId),className:f().container,children:[(0,c.jsx)("div",{className:f().title,children:t.title}),(0,c.jsx)("div",{className:f().contents,children:t.contents.slice(0,35)+"..."}),(0,c.jsxs)("div",{className:f().date,children:[(0,c.jsx)("p",{children:t.createdDate.slice(0,10)}),(0,c.jsx)("p",{children:t.replied?"답변완료":"보류"})]})]},t.inquiryId))})}var m=e(6323),j=e(5497),_=e(4504),w=e(8982),k=e(2258);let Z=[{id:"1",title:"로그인을 해야 과실비율 측정이 되나요?",content:"아니요 측정은 진행되지만 로그인을 하지않으면 후기작성, 기록이 남지않습니다 "},{id:"2",title:"어느정도로 과실비율이 정확한건가요?",content:"실제 과실비율과 정확성 일치는 80-90% 정도로 측정이 되고 있습니다. 하지만 법적효력이 있는건 아니니 참고용으로 사용하시면 좋을거같습니다."}],x=[{icon:(0,c.jsx)(w.Z,{}),name:"문의하기"}];function A(){let t=(0,s.useRouter)(),n=(0,u.v9)(t=>t.auth.isUserAuthenticated),[e,r]=(0,o.useState)({inquiry:!0,faq:!1,announcement:!1}),[l,h]=(0,o.useState)([]),[g,f]=(0,o.useState)([]),[w,A]=(0,o.useState)(1),[q,B]=(0,o.useState)([]),z=5*w,b=z-5;(0,o.useEffect)(()=>{(async function(){let t=await (0,i.NH)();t&&f(t.data.content)})()},[]),(0,o.useEffect)(()=>{(async function(){let t=await (0,i.fB)();t&&h(t.data.content)})(),console.log(l)},[]),(0,o.useEffect)(()=>{l&&B(l.slice(b,z))},[w,l]);let v=()=>{n?t.push("/user/customercenter/inquirywrite"):(alert("로그인이 필요합니다"),t.push("/login"))},N="고객센터",C=(0,c.jsx)(y,{InquiryList:q});return e.inquiry?(C=(0,c.jsx)(y,{InquiryList:q}),N="문의글"):e.faq?(C=Z.map(t=>(0,c.jsx)(p,{title:t.title,content:t.content},t.id)),N="FAQ"):(N="공지사항",C=g.map(t=>(0,c.jsx)(d.Z,{id:t.id,title:t.title,content:t.content},t.id))),(0,c.jsxs)(c.Fragment,{children:[(0,c.jsxs)("div",{className:a().wrapper,children:[(0,c.jsx)(m.Z,{ariaLabel:"SpeedDial basic example",sx:{position:"fixed",bottom:30,right:30},icon:(0,c.jsx)(j.Z,{}),children:x.map(t=>(0,c.jsx)(_.Z,{icon:t.icon,tooltipTitle:t.name,onClick:v},t.name))}),(0,c.jsxs)("div",{className:a().title_box,children:[(0,c.jsx)("h2",{children:N}),(0,c.jsxs)("div",{className:a().category_box,children:[(0,c.jsx)("li",{onClick:()=>{r({inquiry:!0,faq:!1,announcement:!1})},children:"문의글"}),(0,c.jsx)("li",{onClick:()=>{r({inquiry:!1,faq:!0,announcement:!1})},children:"FAQ"}),(0,c.jsx)("li",{onClick:()=>{r({inquiry:!1,faq:!1,announcement:!0})},children:"공지사항"})]})]})]}),C,e.inquiry&&(0,c.jsx)(k.Z,{postsPerPage:5,totalPosts:l.length,paginate:t=>A(t)})]})}},2258:function(t,n,e){"use strict";var c=e(5893),r=e(4924),a=e.n(r);n.Z=t=>{let{postsPerPage:n,totalPosts:e,paginate:r}=t,o=[];for(let t=1;t<=Math.ceil(e/n);t++)o.push(t);return(0,c.jsx)("nav",{children:(0,c.jsx)("ul",{className:a().pagination,children:o.map(t=>(0,c.jsx)("li",{className:a().pageItem,children:(0,c.jsx)("p",{onClick:()=>r(t),children:t})},t))})})}},115:function(t,n,e){"use strict";e.d(n,{Z:function(){return i}});var c=e(5893),r=e(6028),a=e.n(r),o=e(7294);function i(t){let{id:n,title:e,content:r}=t,[i,s]=(0,o.useState)(!1);return(0,c.jsxs)("div",{className:a().container,onClick:()=>{s(t=>!t)},children:[(0,c.jsx)("div",{className:a().title,children:e}),i&&(0,c.jsx)("div",{className:a().answer,children:(0,c.jsx)("div",{className:a().content,children:r})})]})}},8804:function(t){t.exports={wrapper:"customercenter_wrapper__gKrWg",container:"customercenter_container__2N2tS",title_box:"customercenter_title_box__RYkqQ",category_box:"customercenter_category_box__a_orj"}},4924:function(t){t.exports={pagination:"Pagination_pagination__W492h",pageItem:"Pagination_pageItem__rQ71U",pageLink:"Pagination_pageLink__Gb7R2"}},6028:function(t){t.exports={container:"Announcement_container__VtOnJ",title:"Announcement_title__rW57q",content:"Announcement_content__GXgCL",answer:"Announcement_answer___t25H"}},991:function(t){t.exports={container:"Faq_container__Pun7Z",title:"Faq_title__huYrT",content:"Faq_content__p7eRn",answer:"Faq_answer__Oxe_j"}},3774:function(t){t.exports={container:"InquiryList_container__ltOfB",title:"InquiryList_title__ixCaG",contents:"InquiryList_contents__uWGYu",date:"InquiryList_date__VgMLP"}}},function(t){t.O(0,[5121,4938,3138,2888,9774,179],function(){return t(t.s=946)}),_N_E=t.O()}]);