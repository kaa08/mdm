(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[334],{5651:function(t,n,c){"use strict";c.d(n,{Aw:function(){return k},C3:function(){return B},CS:function(){return D},Cx:function(){return F},Fl:function(){return o},GB:function(){return X},GG:function(){return h},HH:function(){return M},HS:function(){return A},JQ:function(){return b},JS:function(){return P},K9:function(){return L},Mk:function(){return T},Mn:function(){return O},NH:function(){return H},NU:function(){return r},O1:function(){return f},OD:function(){return G},OR:function(){return S},Oz:function(){return _},Pk:function(){return g},QC:function(){return x},SQ:function(){return N},Sf:function(){return Q},TD:function(){return z},Tk:function(){return s},Tr:function(){return p},XB:function(){return a},XR:function(){return U},bt:function(){return I},dg:function(){return y},eG:function(){return d},fB:function(){return m},fu:function(){return Z},i1:function(){return l},kZ:function(){return w},mF:function(){return q},mR:function(){return E},oO:function(){return R},pI:function(){return j},ph:function(){return v},r4:function(){return u},s6:function(){return i},wh:function(){return C},zt:function(){return J}});var e=c(5121);async function a(t){try{return(await e.Z.post("http://ceprj.gachon.ac.kr:60011/user/login",t)).data.token}catch(t){alert("아이디와 비밀번호를 확인해주세요"),console.log(t)}}async function r(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/user/update",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n.data}catch(t){console.log(t)}}async function o(t){try{await e.Z.post("http://ceprj.gachon.ac.kr:60011/user/register",t)}catch(t){console.log(t)}}async function i(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/user/checkId?email=".concat(t));return console.log(n),alert("사용할 수 있는 이메일입니다."),200}catch(t){alert("사용할 수 없는 이메일입니다.")}}async function u(t,n){try{return await e.Z.post("http://ceprj.gachon.ac.kr:60011/board/write",t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){return console.log(t),!1}}async function s(t,n,c){try{let a=await e.Z.post("http://ceprj.gachon.ac.kr:60011/board/".concat(c,"/file/upload"),t,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer ".concat(n)}});console.log(a)}catch(t){return console.log(t),!1}}async function l(t,n,c){try{return await e.Z.patch("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/update"),n,{headers:{Authorization:"Bearer ".concat(c)}}),!0}catch(t){return console.log(t),!1}}async function h(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/list?page=".concat(t));return console.log(n),n}catch(t){console.log(t)}}async function p(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/".concat(t))}catch(t){console.log(t)}}async function g(t){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/delete"))}catch(t){console.log(t)}}async function y(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/search?title=".concat(t,"&content=a&writerName=a"))}catch(t){console.log(t)}}async function f(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/list"))}catch(t){console.log(t)}}async function d(t,n,c){try{return await e.Z.post("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/write"),n,{headers:{Authorization:"Bearer ".concat(c)}})}catch(t){console.log(t)}}async function w(t,n,c){try{return await e.Z.delete("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/delete/").concat(n),{headers:{Authorization:"Bearer ".concat(c)}})}catch(t){console.log(t)}}async function k(t,n,c,a){try{return await e.Z.patch("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/update/").concat(n),c,{headers:{Authorization:"Bearer ".concat(a)}}),!0}catch(t){return console.log(t),!1}}async function m(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/inquiry/list?page=".concat(t));return console.log(n),n}catch(t){console.log(t)}}async function j(t,n){try{return await e.Z.post("http://ceprj.gachon.ac.kr:60011/inquiry/write",t,{headers:{Authorization:"Bearer ".concat(n)}}),!0}catch(t){return console.log(t),!1}}async function Z(t,n){try{let c=await e.Z.get("http://ceprj.gachon.ac.kr:60011/inquiry/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}});return console.log(c),c}catch(t){console.log(t)}}async function A(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/user/list?page=".concat(t))}catch(t){console.log(t)}}async function B(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/user/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function z(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/board/list?page=".concat(t))}catch(t){console.log(t)}}async function _(t,n){try{let c=await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/board/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}});console.log(c)}catch(t){console.log(t)}}async function b(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/inquiry/list?page=".concat(t));return console.log(n),n}catch(t){console.log(t)}}async function v(t,n){try{return await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/inquiry/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function C(t,n,c){try{let a=await e.Z.patch("http://ceprj.gachon.ac.kr:60011/admin/inquiry/".concat(t,"/answer"),n,{headers:{Authorization:"Bearer ".concat(c)}});console.log(a)}catch(t){console.log(t)}}async function N(t,n){try{await e.Z.patch("http://ceprj.gachon.ac.kr:60011/mypage/user/update",t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function x(t,n){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/board/list?page=".concat(n),{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function q(t,n){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/comment/list$page=".concat(n),{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function O(t,n){try{let c=await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/inquiry/list?page=".concat(n),{headers:{Authorization:"Bearer ".concat(t)}});return console.log(c),c}catch(t){console.log(t)}}async function S(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/mypage/user/update/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function T(t,n){try{let c=await e.Z.post("http://61.79.137.116:5000/detect",t,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer ".concat(n)}});return console.log(c),c}catch(t){console.error("업로드 에러:",t)}}async function G(t,n,c){try{t.append("ratio",JSON.stringify({ratio:n}));let a=await e.Z.post("http://ceprj.gachon.ac.kr:60011/history/upload",t,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer ".concat(c)}});return console.log(a),a}catch(t){console.error("업로드 에러:",t)}}async function I(t,n){try{let c=await e.Z.get("http://ceprj.gachon.ac.kr:60011/history/download?historyId=".concat(t),{headers:{Authorization:"Bearer ".concat(n)},responseType:"blob"});return console.log(c),c.data}catch(t){console.error("업로드 에러:",t)}}async function H(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/notice/list?page=".concat(t));return console.log(n),n}catch(t){console.log(t)}}async function J(t,n){try{let c=await e.Z.post("http://ceprj.gachon.ac.kr:60011/admin/notice/write",t,{headers:{Authorization:"Bearer ".concat(n)}});return console.log(c),c}catch(t){console.error("업로드 에러:",t)}}async function P(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/notice/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function Q(t,n){try{let c=await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/history/list?page=".concat(n),{headers:{Authorization:"Bearer ".concat(t)}});return console.log(c),c}catch(t){console.log(t)}}async function R(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/review/list?page=".concat(t));return console.log(n),n}catch(t){console.error("업로드 에러:",t)}}async function L(t,n){try{let c=await e.Z.post("http://ceprj.gachon.ac.kr:60011/review/write",t,{headers:{Authorization:"Bearer ".concat(n)}});return console.log(c),c}catch(t){console.error("업로드 에러:",t)}}async function M(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/review/".concat(t));return console.log(n),n}catch(t){console.error("업로드 에러:",t)}}async function X(t,n,c){try{let a=await e.Z.patch("http://ceprj.gachon.ac.kr:60011/review/".concat(t,"/update"),n,{headers:{Authorization:"Bearer ".concat(c)}});return console.log(a),a}catch(t){console.error("업로드 에러:",t)}}async function D(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/review/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function E(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/review/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function F(t,n){try{let c=await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/review/list?page=".concat(n),{headers:{Authorization:"Bearer ".concat(t)}});return console.log(c),c}catch(t){console.error("업로드 에러:",t)}}async function U(){try{let t=await e.Z.get("http://61.79.137.116:5000/status");return console.log(t),alert("서버가 켜져있어요"),t}catch(t){console.error("업로드 에러:",t),alert("서버가 꺼져있어요")}}},2258:function(t,n,c){"use strict";var e=c(5893),a=c(4924),r=c.n(a);n.Z=t=>{let{totalPage:n,paginate:c}=t,a=[];for(let t=1;t<=Math.ceil(n);t++)a.push(t);return(0,e.jsx)("nav",{children:(0,e.jsx)("ul",{className:r().pagination,children:a.map(t=>(0,e.jsx)("li",{className:r().pageItem,children:(0,e.jsx)("p",{onClick:()=>c(t),children:t})},t))})})}},115:function(t,n,c){"use strict";c.d(n,{Z:function(){return i}});var e=c(5893),a=c(6028),r=c.n(a),o=c(7294);function i(t){let{id:n,title:c,content:a}=t,[i,u]=(0,o.useState)(!1);return(0,e.jsxs)("div",{className:r().container,onClick:()=>{u(t=>!t)},children:[(0,e.jsx)("div",{className:r().title,children:c}),i&&(0,e.jsx)("div",{className:r().answer,children:(0,e.jsx)("div",{className:r().content,children:a})})]})}},4924:function(t){t.exports={pagination:"Pagination_pagination__W492h",pageItem:"Pagination_pageItem__rQ71U",pageLink:"Pagination_pageLink__Gb7R2"}},6028:function(t){t.exports={container:"Announcement_container__VtOnJ",title:"Announcement_title__rW57q",content:"Announcement_content__GXgCL",answer:"Announcement_answer___t25H"}}}]);