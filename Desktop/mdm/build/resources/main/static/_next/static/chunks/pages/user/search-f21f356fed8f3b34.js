(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[9852],{1593:function(t,n,c){(window.__NEXT_P=window.__NEXT_P||[]).push(["/user/search",function(){return c(3844)}])},5651:function(t,n,c){"use strict";c.d(n,{AD:function(){return S},Aw:function(){return m},C3:function(){return b},Cx:function(){return Y},Fl:function(){return a},GG:function(){return l},HH:function(){return M},HS:function(){return Z},JQ:function(){return A},JS:function(){return F},K9:function(){return G},Mk:function(){return I},Mn:function(){return q},NH:function(){return D},NU:function(){return o},O1:function(){return y},OD:function(){return P},OR:function(){return T},Oz:function(){return B},Pk:function(){return g},QC:function(){return C},SQ:function(){return N},Sf:function(){return J},TD:function(){return z},Tk:function(){return s},Tr:function(){return p},XB:function(){return r},_I:function(){return E},bt:function(){return R},dg:function(){return d},eG:function(){return f},fB:function(){return j},fu:function(){return k},i1:function(){return h},kZ:function(){return w},mF:function(){return O},mR:function(){return X},oO:function(){return Q},pI:function(){return _},ph:function(){return x},r4:function(){return u},s6:function(){return i},wh:function(){return v},zt:function(){return H}});var e=c(5121);async function r(t){try{return(await e.Z.post("http://ceprj.gachon.ac.kr:60011/user/login",t)).data.token}catch(t){alert("아이디와 비밀번호를 확인해주세요"),console.log(t)}}async function o(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/user/update",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n.data}catch(t){console.log(t)}}async function a(t){try{await e.Z.post("http://ceprj.gachon.ac.kr:60011/user/register",t)}catch(t){console.log(t)}}async function i(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/user/checkId?email=".concat(t));return console.log(n),alert("사용할 수 있는 이메일입니다."),200}catch(t){alert("사용할 수 없는 이메일입니다.")}}async function u(t,n){try{return await e.Z.post("http://ceprj.gachon.ac.kr:60011/board/write",t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){return console.log(t),!1}}async function s(t,n,c){try{await e.Z.post("http://ceprj.gachon.ac.kr:60011/board/".concat(c,"/file/upload"),t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){return console.log(t),!1}}async function h(t,n,c){try{return await e.Z.patch("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/update"),n,{headers:{Authorization:"Bearer ".concat(c)}}),!0}catch(t){return console.log(t),!1}}async function l(){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/list")}catch(t){console.log(t)}}async function p(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/".concat(t))}catch(t){console.log(t)}}async function g(t){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/delete"))}catch(t){console.log(t)}}async function d(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/search?title=".concat(t,"&content=a&writerName=a"))}catch(t){console.log(t)}}async function y(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/list"))}catch(t){console.log(t)}}async function f(t,n,c){try{return await e.Z.post("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/write"),n,{headers:{Authorization:"Bearer ".concat(c)}})}catch(t){console.log(t)}}async function w(t,n,c){try{return await e.Z.delete("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/delete/").concat(n),{headers:{Authorization:"Bearer ".concat(c)}})}catch(t){console.log(t)}}async function m(t,n,c,r){try{return await e.Z.patch("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/update/").concat(n),c,{headers:{Authorization:"Bearer ".concat(r)}}),!0}catch(t){return console.log(t),!1}}async function j(){try{let t=await e.Z.get("http://ceprj.gachon.ac.kr:60011/inquiry/list");return console.log(t),t}catch(t){console.log(t)}}async function _(t,n){try{return await e.Z.post("http://ceprj.gachon.ac.kr:60011/inquiry/write",t,{headers:{Authorization:"Bearer ".concat(n)}}),!0}catch(t){return console.log(t),!1}}async function k(t,n){try{let c=await e.Z.get("http://ceprj.gachon.ac.kr:60011/inquiry/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}});return console.log(c),c}catch(t){console.log(t)}}async function Z(){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/user/list")}catch(t){console.log(t)}}async function b(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/user/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function z(){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/board/list")}catch(t){console.log(t)}}async function B(t,n){try{let c=await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/board/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}});console.log(c)}catch(t){console.log(t)}}async function A(){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/inquiry/list")}catch(t){console.log(t)}}async function x(t,n){try{return await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/inquiry/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function v(t,n,c){try{let r=await e.Z.patch("http://ceprj.gachon.ac.kr:60011/admin/inquiry/".concat(t,"/answer"),n,{headers:{Authorization:"Bearer ".concat(c)}});console.log(r)}catch(t){console.log(t)}}async function N(t,n){try{await e.Z.patch("http://ceprj.gachon.ac.kr:60011/mypage/user/update",t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function C(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/board/list",{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function O(t){try{return await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/comment/list",{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function q(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/inquiry/list",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n}catch(t){console.log(t)}}async function S(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/mypage/board/list/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function E(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/mypage/comment/list/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function T(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/mypage/user/update/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function I(t,n){try{let c=await e.Z.post("http://61.79.137.116:5000/detect",t,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer ".concat(n)}});return console.log(c),c}catch(t){console.error("업로드 에러:",t)}}async function P(t,n,c){try{t.append("ratio",JSON.stringify({ratio:n}));let r=await e.Z.post("http://ceprj.gachon.ac.kr:60011/history/upload",t,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer ".concat(c)}});return console.log(r),r}catch(t){console.error("업로드 에러:",t)}}async function R(t,n){try{let c=await e.Z.get("http://ceprj.gachon.ac.kr:60011/history/download?historyId=".concat(t),{headers:{Authorization:"Bearer ".concat(n)},responseType:"blob"});return console.log(c),c.data}catch(t){console.error("업로드 에러:",t)}}async function D(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/admin/notice/list",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n}catch(t){console.log(t)}}async function H(t,n){try{let c=await e.Z.post("http://ceprj.gachon.ac.kr:60011/admin/notice/write",t,{headers:{Authorization:"Bearer ".concat(n)}});return console.log(c),c}catch(t){console.error("업로드 에러:",t)}}async function F(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/notice/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function J(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/history/list",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n}catch(t){console.log(t)}}async function Q(){try{let t=await e.Z.get("http://ceprj.gachon.ac.kr:60011/review/list");return console.log(t),t}catch(t){console.error("업로드 에러:",t)}}async function G(t,n){try{let c=await e.Z.post("http://ceprj.gachon.ac.kr:60011/review/write",t,{headers:{Authorization:"Bearer ".concat(n)}});return console.log(c),c}catch(t){console.error("업로드 에러:",t)}}async function M(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/review/".concat(t));return console.log(n),n}catch(t){console.error("업로드 에러:",t)}}async function X(t,n){try{await e.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/review/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function Y(t){try{let n=await e.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/review/list",{Authorization:"Bearer ".concat(t)});return console.log(n),n}catch(t){console.error("업로드 에러:",t)}}},3844:function(t,n,c){"use strict";c.r(n),c.d(n,{default:function(){return l}});var e=c(5893),r=c(7294),o=c(5651),a=c(5542);function i(t){let{q:n}=t,[c,i]=(0,r.useState)();return(0,r.useEffect)(()=>{(async function(){i((await (0,o.dg)(n)).data.content)})()},[n]),(0,e.jsx)(e.Fragment,{children:c&&c.map(t=>(0,e.jsx)(a.Z,{id:t.boardId,title:t.title,content:t.content,viewCount:t.viewCount,commentNum:0},t.boardId))})}var u=c(9588),s=c.n(u),h=c(1163);function l(){let{q:t}=(0,h.useRouter)().query;return(0,e.jsx)("div",{className:s().wrapper,children:(0,e.jsxs)("div",{className:s().container,children:[(0,e.jsx)("div",{className:s().box,children:(0,e.jsxs)("h2",{children:["“",t,"” 의 검색결과"]})}),(0,e.jsx)(i,{q:t})]})})}},5542:function(t,n,c){"use strict";c.d(n,{Z:function(){return l}});var e=c(5893),r=c(1163),o=c(1182),a=c.n(o),i=c(2091),u=c(80),s=c(7294),h=c(5651);function l(t){let{id:n,title:c,content:o,viewCount:l}=t,p=(0,r.useRouter)(),[g,d]=(0,s.useState)();return(0,s.useEffect)(()=>{(async()=>{let t=await (0,h.O1)(n);t&&d(t.data.totalElements)})()},[n]),(0,e.jsxs)("div",{className:a().container,onClick:()=>{p.push("/user/community/communityDetail/".concat(n))},children:[(0,e.jsx)("div",{className:a().title,children:c}),(0,e.jsx)("div",{className:a().content,children:o.slice(0,75)}),(0,e.jsxs)("div",{className:a().like,children:[(0,e.jsx)(i.z5B,{size:20}),l,(0,e.jsx)(u.iSW,{size:20,color:"#849b9f"}),(0,e.jsx)("p",{style:{color:"#849b9f"},children:g})]})]})}},9588:function(t){t.exports={wrapper:"search_wrapper__D_I9m",container:"search_container__3NiJ1",box:"search_box__etZbl",category_box:"search_category_box__c4ASR",middle_menu:"search_middle_menu__TMqi_",button:"search_button__u6E5u",content_box:"search_content_box__Ch57j",content_wrapper:"search_content_wrapper__2stmR"}},1182:function(t){t.exports={container:"CommunityPost_container__tBihv",title:"CommunityPost_title__boYOQ",content:"CommunityPost_content__SOYjF",like:"CommunityPost_like__CHvj7"}}},function(t){t.O(0,[3365,4838,5121,2888,9774,179],function(){return t(t.s=1593)}),_N_E=t.O()}]);