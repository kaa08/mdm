(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[383],{7717:function(t,n,c){(window.__NEXT_P=window.__NEXT_P||[]).push(["/admin/usermanage",function(){return c(9996)}])},9996:function(t,n,c){"use strict";c.r(n),c.d(n,{default:function(){return d}});var e=c(5893),r=c(7294),a=c(9441),o=c.n(a),i=c(5651),u=c(7845),h=c.n(u);function s(t){let{myName:n,email:c,nickname:r,birth:a,driveExp:o,memberId:u}=t;return(0,e.jsxs)("tr",{children:[(0,e.jsx)("td",{children:n}),(0,e.jsx)("td",{children:c}),(0,e.jsx)("td",{children:r}),(0,e.jsx)("td",{children:a}),(0,e.jsx)("td",{children:o}),(0,e.jsx)("td",{className:h().delete,onClick:()=>{let t=confirm("삭제하시겠습니까?");t&&(console.log(t),(0,i.C3)(u))},children:"삭제"})]})}function l(){let[t,n]=(0,r.useState)();return(0,r.useEffect)(()=>{(async function(){let c=await (0,i.HS)();c&&(n(c.data.content),console.log(t))})()},[]),(0,e.jsx)("div",{className:o().tableContainer,children:(0,e.jsxs)("table",{className:o().table,children:[(0,e.jsx)("thead",{children:(0,e.jsxs)("tr",{children:[(0,e.jsx)("th",{children:"이름"}),(0,e.jsx)("th",{children:"이메일"}),(0,e.jsx)("th",{children:"닉네임"}),(0,e.jsx)("th",{children:"생년월일"}),(0,e.jsx)("th",{children:"운전경력"}),(0,e.jsx)("th",{children:"옵션"})]})}),(0,e.jsx)("tbody",{className:o().body,children:t&&t.map(t=>(0,e.jsx)(s,{memberId:t.memberId,myName:t.myName,email:t.email,nickname:t.nickname,birth:t.birth,driveExp:t.driveExp},t.email))})]})})}function d(){return(0,e.jsx)(e.Fragment,{children:(0,e.jsx)(l,{})})}},5651:function(t,n,c){"use strict";c.d(n,{AD:function(){return T},Aw:function(){return m},C3:function(){return Z},Fl:function(){return o},GG:function(){return s},HS:function(){return b},JQ:function(){return A},Mk:function(){return O},Mn:function(){return v},NU:function(){return a},O1:function(){return g},OR:function(){return q},Oz:function(){return _},Pk:function(){return d},QC:function(){return C},SQ:function(){return N},TD:function(){return x},Tk:function(){return u},Tr:function(){return l},XB:function(){return r},_I:function(){return U},dg:function(){return p},eG:function(){return f},fB:function(){return j},fu:function(){return k},i1:function(){return h},kZ:function(){return y},mF:function(){return E},pI:function(){return w},ph:function(){return z},r4:function(){return i},wh:function(){return B},zU:function(){return M}});var e=c(5121);async function r(t){try{return(await e.Z.post("http://ceprj.gachon.ac.kr:60011/user/login",t)).data.token}catch(t){alert("아이디와 비밀번호를 확인해주세요"),console.log(t)}}async function a(t){try{return(await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/user/update",{headers:{Authorization:"Bearer ".concat(t)}})).data}catch(t){console.log(t)}}async function o(t){try{await e.Z.post("http://ceprj.gachon.ac.kr:60011/user/register",t)}catch(t){console.log(t)}}async function i(t,n){try{return await e.Z.post("http://ceprj.gachon.ac.kr:60011/board/write",t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){return console.log(t),!1}}async function u(t,n,c){try{await e.Z.post("http://ceprj.gachon.ac.kr:60011/board/".concat(c,"/file/upload"),t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){return console.log(t),!1}}async function h(t,n,c){try{return await e.Z.patch("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/update"),n,{headers:{Authorization:"Bearer ".concat(c)}}),!0}catch(t){return console.log(t),!1}}async function s(){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/list")}catch(t){console.log(t)}}async function l(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/".concat(t))}catch(t){console.log(t)}}async function d(t){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/delete"))}catch(t){console.log(t)}}async function p(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/search?title=".concat(t,"&content=a&writerName=a"))}catch(t){console.log(t)}}async function g(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/list"))}catch(t){console.log(t)}}async function f(t,n,c){try{return await e.Z.post("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/write"),n,{headers:{Authorization:"Bearer ".concat(c)}})}catch(t){console.log(t)}}async function y(t,n,c){try{return await e.Z.delete("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/delete/").concat(n),{headers:{Authorization:"Bearer ".concat(c)}})}catch(t){console.log(t)}}async function m(t,n,c,r){try{return await e.Z.patch("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/update/").concat(n),c,{headers:{Authorization:"Bearer ".concat(r)}}),!0}catch(t){return console.log(t),!1}}async function j(){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/inquiry/list")}catch(t){console.log(t)}}async function w(t,n){try{return await e.Z.post("http://ceprj.gachon.ac.kr:60011/inquiry/write",t,{headers:{Authorization:"Bearer ".concat(n)}}),!0}catch(t){return console.log(t),!1}}async function k(t,n){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/inquiry/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function b(){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/user/list")}catch(t){console.log(t)}}async function Z(t){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/user/delete/".concat(t))}catch(t){console.log(t)}}async function x(){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/board/list")}catch(t){console.log(t)}}async function _(t){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/board/delete/".concat(t))}catch(t){console.log(t)}}async function A(){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/inquiry/list")}catch(t){console.log(t)}}async function z(t){try{return await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/inquiry/delete/".concat(t))}catch(t){console.log(t)}}async function B(t,n){try{await e.Z.patch("http://ceprj.gachon.ac.kr:60011/admin/inquiry/".concat(t,"/answer"),n)}catch(t){console.log(t)}}async function N(t,n){try{await e.Z.patch("http://ceprj.gachon.ac.kr:60011/mypage/user/update",t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function C(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/board/list",{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function E(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/comment/list",{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function v(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/inquiry/list",{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function T(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/mypage/board/list/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function U(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/mypage/comment/list/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function q(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/mypage/user/update/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function M(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/video/download?videoId=6",{headers:{Authorization:"Bearer ".concat(t)},responseType:"blob"});return window.URL.createObjectURL(n.data)}catch(t){console.log(t)}}async function O(t,n){try{let c=await e.Z.post("http://61.79.137.116:5000/detect",t,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer ".concat(n)}});return console.log(c),c}catch(t){console.error("업로드 에러:",t)}}},9441:function(t){t.exports={tableContainer:"AdminUserManage_tableContainer__0C8sS",table:"AdminUserManage_table__fF9go",body:"AdminUserManage_body__JEvaa"}},7845:function(t){t.exports={delete:"AdminUserManageTr_delete__dGzn8"}}},function(t){t.O(0,[121,888,774,179],function(){return t(t.s=7717)}),_N_E=t.O()}]);