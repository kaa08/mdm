(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[466],{2475:function(t,n,c){(window.__NEXT_P=window.__NEXT_P||[]).push(["/user/customercenter/inquirywrite",function(){return c(7987)}])},5651:function(t,n,c){"use strict";c.d(n,{AD:function(){return T},Aw:function(){return _},C3:function(){return b},Fl:function(){return o},GG:function(){return h},HS:function(){return j},JQ:function(){return B},Mn:function(){return C},NU:function(){return a},O1:function(){return y},OR:function(){return E},Oz:function(){return x},Pk:function(){return p},QC:function(){return N},SQ:function(){return A},TD:function(){return Z},Tk:function(){return u},Tr:function(){return l},XB:function(){return r},_I:function(){return O},dg:function(){return g},eG:function(){return d},fB:function(){return w},fu:function(){return k},i1:function(){return s},kZ:function(){return f},mF:function(){return v},pI:function(){return m},ph:function(){return q},r4:function(){return i},wh:function(){return z},zU:function(){return S}});var e=c(5121);async function r(t){try{return(await e.Z.post("http://ceprj.gachon.ac.kr:60011/user/login",t)).data.token}catch(t){alert("아이디와 비밀번호를 확인해주세요"),console.log(t)}}async function a(t){try{return(await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/user/update",{headers:{Authorization:"Bearer ".concat(t)}})).data}catch(t){console.log(t)}}async function o(t){try{await e.Z.post("http://ceprj.gachon.ac.kr:60011/user/register",t)}catch(t){console.log(t)}}async function i(t,n){try{return await e.Z.post("http://ceprj.gachon.ac.kr:60011/board/write",t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){return console.log(t),!1}}async function u(t,n,c){try{await e.Z.post("http://ceprj.gachon.ac.kr:60011/board/".concat(c,"/file/upload"),t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){return console.log(t),!1}}async function s(t,n,c){try{return await e.Z.patch("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/update"),n,{headers:{Authorization:"Bearer ".concat(c)}}),!0}catch(t){return console.log(t),!1}}async function h(){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/list")}catch(t){console.log(t)}}async function l(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/".concat(t))}catch(t){console.log(t)}}async function p(t){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/delete"))}catch(t){console.log(t)}}async function g(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/search?title=".concat(t,"&content=a&writerName=a"))}catch(t){console.log(t)}}async function y(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/list"))}catch(t){console.log(t)}}async function d(t,n,c){try{return await e.Z.post("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/write"),n,{headers:{Authorization:"Bearer ".concat(c)}})}catch(t){console.log(t)}}async function f(t,n,c){try{return await e.Z.delete("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/delete/").concat(n),{headers:{Authorization:"Bearer ".concat(c)}})}catch(t){console.log(t)}}async function _(t,n,c,r){try{return await e.Z.patch("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/update/").concat(n),c,{headers:{Authorization:"Bearer ".concat(r)}}),!0}catch(t){return console.log(t),!1}}async function w(){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/inquiry/list")}catch(t){console.log(t)}}async function m(t,n){try{return await e.Z.post("http://ceprj.gachon.ac.kr:60011/inquiry/write",t,{headers:{Authorization:"Bearer ".concat(n)}}),!0}catch(t){return console.log(t),!1}}async function k(t,n){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/inquiry/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function j(){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/user/list")}catch(t){console.log(t)}}async function b(t){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/user/delete/".concat(t))}catch(t){console.log(t)}}async function Z(){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/board/list")}catch(t){console.log(t)}}async function x(t){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/board/delete/".concat(t))}catch(t){console.log(t)}}async function B(){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/inquiry/list")}catch(t){console.log(t)}}async function q(t){try{return await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/inquiry/delete/".concat(t))}catch(t){console.log(t)}}async function z(t,n){try{await e.Z.patch("http://ceprj.gachon.ac.kr:60011/admin/inquiry/".concat(t,"/answer"),n)}catch(t){console.log(t)}}async function A(t,n){try{await e.Z.patch("http://ceprj.gachon.ac.kr:60011/mypage/user/update",t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function N(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/board/list",{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function v(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/comment/list",{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function C(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/inquiry/list",{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function T(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/mypage/board/list/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function O(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/mypage/comment/list/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function E(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/mypage/user/update/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function S(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/video/download?videoId=6",{headers:{Authorization:"Bearer ".concat(t)},responseType:"blob"});return window.URL.createObjectURL(n.data)}catch(t){console.log(t)}}},7987:function(t,n,c){"use strict";c.r(n),c.d(n,{default:function(){return s}});var e=c(5893),r=c(7294),a=c(8285),o=c.n(a),i=c(1163),u=c(5651);function s(){let t=(0,i.useRouter)(),[n,c]=(0,r.useState)(),[a,s]=(0,r.useState)({title:"",contents:""});(0,r.useEffect)(()=>{c(localStorage.getItem("loginToken")),console.log(n)},[n]);let h=t=>{s({...a,[t.target.name]:t.target.value})},l=async c=>{if(""===a.title||""===a.contents){alert("제목과 내용을 입력해주세요.");return}c.preventDefault(),await (0,u.pI)(a,n)?(alert("새 글이 게시되었습니다."),t.push("/user/customercenter"),console.log(a)):console.error("에러")};return(0,e.jsxs)("form",{onSubmit:l,className:o().wrapper,children:[(0,e.jsxs)("div",{className:o().container,children:[(0,e.jsx)("div",{className:o().box,children:(0,e.jsx)("h2",{children:"문의하기"})}),(0,e.jsxs)("div",{className:o().content_box,children:[(0,e.jsxs)("div",{className:o().title,children:[(0,e.jsx)("span",{children:"제목: "}),(0,e.jsx)("textarea",{name:"title",onChange:h,className:o().title_post,value:a.title})]}),(0,e.jsx)("textarea",{name:"contents",className:o().content,onChange:h,value:a.contents})]})]}),(0,e.jsx)("div",{className:o().new_post,children:(0,e.jsx)("button",{type:"submit",className:o().button,children:"문의하기"})})]})}},8285:function(t){t.exports={wrapper:"inquiry_wrapper__CxFds",container:"inquiry_container__1h7Yg",box:"inquiry_box__tGWan",search_bar:"inquiry_search_bar__Okm9w",paging:"inquiry_paging__CRFdB",new_post:"inquiry_new_post__BCHCr",content_box:"inquiry_content_box___Usge",title:"inquiry_title__ykL7l",title_post:"inquiry_title_post__2DG0b",content:"inquiry_content__iY6Ua",like:"inquiry_like__XloKb",button:"inquiry_button__mQgTY"}}},function(t){t.O(0,[121,888,774,179],function(){return t(t.s=2475)}),_N_E=t.O()}]);