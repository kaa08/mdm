(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[8466],{2475:function(t,n,c){(window.__NEXT_P=window.__NEXT_P||[]).push(["/user/customercenter/inquirywrite",function(){return c(7987)}])},5651:function(t,n,c){"use strict";c.d(n,{Aw:function(){return _},C3:function(){return b},CS:function(){return P},Cx:function(){return Y},Fl:function(){return a},GB:function(){return J},GG:function(){return h},HH:function(){return Q},HS:function(){return Z},JQ:function(){return A},JS:function(){return R},K9:function(){return F},Mk:function(){return O},Mn:function(){return T},NH:function(){return H},NU:function(){return o},O1:function(){return f},OD:function(){return E},OR:function(){return S},Oz:function(){return z},Pk:function(){return g},QC:function(){return N},SQ:function(){return v},Sf:function(){return X},TD:function(){return B},Tk:function(){return s},Tr:function(){return p},XB:function(){return r},XR:function(){return K},bt:function(){return G},dg:function(){return y},eG:function(){return d},fB:function(){return m},fu:function(){return j},i1:function(){return l},kZ:function(){return w},mF:function(){return C},mR:function(){return U},oO:function(){return D},pI:function(){return k},ph:function(){return x},r4:function(){return u},s6:function(){return i},wh:function(){return q},zt:function(){return I}});var e=c(5121);async function r(t){try{return(await e.Z.post("http://ceprj.gachon.ac.kr:60011/user/login",t)).data.token}catch(t){alert("아이디와 비밀번호를 확인해주세요"),console.log(t)}}async function o(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/user/update",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n.data}catch(t){console.log(t)}}async function a(t){try{await e.Z.post("http://ceprj.gachon.ac.kr:60011/user/register",t)}catch(t){console.log(t)}}async function i(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/user/checkId?email=".concat(t));return console.log(n),alert("사용할 수 있는 이메일입니다."),200}catch(t){alert("사용할 수 없는 이메일입니다.")}}async function u(t,n){try{return await e.Z.post("http://ceprj.gachon.ac.kr:60011/board/write",t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){return console.log(t),!1}}async function s(t,n,c){try{let r=await e.Z.post("http://ceprj.gachon.ac.kr:60011/board/".concat(c,"/file/upload"),t,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer ".concat(n)}});console.log(r)}catch(t){return console.log(t),!1}}async function l(t,n,c){try{return await e.Z.patch("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/update"),n,{headers:{Authorization:"Bearer ".concat(c)}}),!0}catch(t){return console.log(t),!1}}async function h(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/list?page=".concat(t));return console.log(n),n}catch(t){console.log(t)}}async function p(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/".concat(t))}catch(t){console.log(t)}}async function g(t){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/delete"))}catch(t){console.log(t)}}async function y(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/search?title=".concat(t,"&content=a&writerName=a"))}catch(t){console.log(t)}}async function f(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/list"))}catch(t){console.log(t)}}async function d(t,n,c){try{return await e.Z.post("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/write"),n,{headers:{Authorization:"Bearer ".concat(c)}})}catch(t){console.log(t)}}async function w(t,n,c){try{return await e.Z.delete("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/delete/").concat(n),{headers:{Authorization:"Bearer ".concat(c)}})}catch(t){console.log(t)}}async function _(t,n,c,r){try{return await e.Z.patch("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/update/").concat(n),c,{headers:{Authorization:"Bearer ".concat(r)}}),!0}catch(t){return console.log(t),!1}}async function m(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/inquiry/list?page=".concat(t));return console.log(n),n}catch(t){console.log(t)}}async function k(t,n){try{return await e.Z.post("http://ceprj.gachon.ac.kr:60011/inquiry/write",t,{headers:{Authorization:"Bearer ".concat(n)}}),!0}catch(t){return console.log(t),!1}}async function j(t,n){try{let c=await e.Z.get("http://ceprj.gachon.ac.kr:60011/inquiry/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}});return console.log(c),c}catch(t){console.log(t)}}async function Z(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/user/list?page=".concat(t))}catch(t){console.log(t)}}async function b(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/user/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function B(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/board/list?page=".concat(t))}catch(t){console.log(t)}}async function z(t,n){try{let c=await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/board/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}});console.log(c)}catch(t){console.log(t)}}async function A(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/inquiry/list?page=".concat(t));return console.log(n),n}catch(t){console.log(t)}}async function x(t,n){try{return await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/inquiry/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function q(t,n,c){try{let r=await e.Z.patch("http://ceprj.gachon.ac.kr:60011/admin/inquiry/".concat(t,"/answer"),n,{headers:{Authorization:"Bearer ".concat(c)}});console.log(r)}catch(t){console.log(t)}}async function v(t,n){try{await e.Z.patch("http://ceprj.gachon.ac.kr:60011/mypage/user/update",t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function N(t,n){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/board/list?page=".concat(n),{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function C(t,n){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/comment/list$page=".concat(n),{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function T(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/inquiry/list",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n}catch(t){console.log(t)}}async function S(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/mypage/user/update/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function O(t,n){try{let c=await e.Z.post("http://61.79.137.116:5000/detect",t,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer ".concat(n)}});return console.log(c),c}catch(t){console.error("업로드 에러:",t)}}async function E(t,n,c){try{t.append("ratio",JSON.stringify({ratio:n}));let r=await e.Z.post("http://ceprj.gachon.ac.kr:60011/history/upload",t,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer ".concat(c)}});return console.log(r),r}catch(t){console.error("업로드 에러:",t)}}async function G(t,n){try{let c=await e.Z.get("http://ceprj.gachon.ac.kr:60011/history/download?historyId=".concat(t),{headers:{Authorization:"Bearer ".concat(n)},responseType:"blob"});return console.log(c),c.data}catch(t){console.error("업로드 에러:",t)}}async function H(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/notice/list?page=".concat(t));return console.log(n),n}catch(t){console.log(t)}}async function I(t,n){try{let c=await e.Z.post("http://ceprj.gachon.ac.kr:60011/admin/notice/write",t,{headers:{Authorization:"Bearer ".concat(n)}});return console.log(c),c}catch(t){console.error("업로드 에러:",t)}}async function R(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/notice/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function X(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/history/list",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n}catch(t){console.log(t)}}async function D(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/review/list?page=".concat(t));return console.log(n),n}catch(t){console.error("업로드 에러:",t)}}async function F(t,n){try{let c=await e.Z.post("http://ceprj.gachon.ac.kr:60011/review/write",t,{headers:{Authorization:"Bearer ".concat(n)}});return console.log(c),c}catch(t){console.error("업로드 에러:",t)}}async function Q(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/review/".concat(t));return console.log(n),n}catch(t){console.error("업로드 에러:",t)}}async function J(t,n,c){try{let r=await e.Z.patch("http://ceprj.gachon.ac.kr:60011/review/".concat(t,"/update"),n,{headers:{Authorization:"Bearer ".concat(c)}});return console.log(r),r}catch(t){console.error("업로드 에러:",t)}}async function P(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/review/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function U(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/review/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function Y(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/review/list",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n}catch(t){console.error("업로드 에러:",t)}}async function K(){try{let t=await e.Z.get("http://61.79.137.116:5000/status");return console.log(t),alert("서버가 켜져있어요"),t}catch(t){console.error("업로드 에러:",t),alert("서버가 꺼져있어요")}}},7987:function(t,n,c){"use strict";c.r(n),c.d(n,{default:function(){return s}});var e=c(5893),r=c(7294),o=c(8285),a=c.n(o),i=c(1163),u=c(5651);function s(){let t=(0,i.useRouter)(),[n,c]=(0,r.useState)(),[o,s]=(0,r.useState)({title:"",contents:""});(0,r.useEffect)(()=>{c(localStorage.getItem("loginToken")),console.log(n)},[n]);let l=t=>{s({...o,[t.target.name]:t.target.value})},h=async c=>{if(""===o.title||""===o.contents){alert("제목과 내용을 입력해주세요.");return}c.preventDefault(),await (0,u.pI)(o,n)?(alert("새 글이 게시되었습니다."),t.push("/user/customercenter"),console.log(o)):console.error("에러")};return(0,e.jsxs)("form",{onSubmit:h,className:a().wrapper,children:[(0,e.jsxs)("div",{className:a().container,children:[(0,e.jsx)("div",{className:a().box,children:(0,e.jsx)("h2",{children:"문의하기"})}),(0,e.jsxs)("div",{className:a().content_box,children:[(0,e.jsxs)("div",{className:a().title,children:[(0,e.jsx)("span",{children:"제목: "}),(0,e.jsx)("textarea",{name:"title",onChange:l,className:a().title_post,value:o.title})]}),(0,e.jsx)("textarea",{name:"contents",className:a().content,onChange:l,value:o.contents})]})]}),(0,e.jsx)("div",{className:a().new_post,children:(0,e.jsx)("button",{type:"submit",className:a().button,children:"문의하기"})})]})}},8285:function(t){t.exports={wrapper:"inquiry_wrapper__CxFds",container:"inquiry_container__1h7Yg",box:"inquiry_box__tGWan",search_bar:"inquiry_search_bar__Okm9w",paging:"inquiry_paging__CRFdB",new_post:"inquiry_new_post__BCHCr",content_box:"inquiry_content_box___Usge",title:"inquiry_title__ykL7l",title_post:"inquiry_title_post__2DG0b",content:"inquiry_content__iY6Ua",like:"inquiry_like__XloKb",button:"inquiry_button__mQgTY"}}},function(t){t.O(0,[5121,2888,9774,179],function(){return t(t.s=2475)}),_N_E=t.O()}]);