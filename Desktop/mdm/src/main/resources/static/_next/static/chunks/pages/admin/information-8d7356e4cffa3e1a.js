(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[7434],{6767:function(t,n,e){(window.__NEXT_P=window.__NEXT_P||[]).push(["/admin/information",function(){return e(250)}])},250:function(t,n,e){"use strict";e.r(n),e.d(n,{default:function(){return d}});var c=e(5893),o=e(115),r=e(5651),a=e(371),i=e.n(a),u=e(9417),l=e(7294),s=e(93),h=e(1163);function d(){let[t,n]=(0,l.useState)(!1),[e,a]=(0,l.useState)(""),[d,p]=(0,l.useState)(""),[g,f]=(0,l.useState)([]),y=(0,h.useRouter)();(0,l.useEffect)(()=>{let t=localStorage.getItem("loginToken");(async()=>{let n=await (0,r.NH)(t);n&&f(n.data.content)})()},[]);let w=async t=>{confirm("해당 게시글을 삭제하시겠습니까?")&&(await (0,r.JS)(t),alert("삭제되었습니다."),y.push("/admin"))},m=async()=>{let t=localStorage.getItem("loginToken");await (0,r.zt)({title:e,content:d},t)&&(alert("공지사항이 게시되었습니다."),n(!1),y.push("/admin"))};return(0,c.jsxs)("div",{className:i().box,children:[t&&(0,c.jsxs)(s.Z,{children:[(0,c.jsxs)("div",{className:i().wrtie_box,children:[(0,c.jsx)("textarea",{placeholder:"제목을 입력해주세요",onChange:t=>{a(t.target.value)},className:i().write_title,value:e}),(0,c.jsx)("textarea",{placeholder:"공지내용을 입력해주세요",onChange:t=>{p(t.target.value)},className:i().write_content,value:d})]}),(0,c.jsxs)("div",{className:i().modal_button,children:[(0,c.jsx)(u.Z,{onClick:m,children:"작성"}),(0,c.jsx)(u.Z,{onClick:()=>{n(!1)},children:"닫기"})]})]}),(0,c.jsx)("div",{className:i().button_box,children:(0,c.jsx)(u.Z,{onClick:()=>{n(!0)},children:"공지사항 작성"})}),g&&g.map(t=>(0,c.jsxs)(c.Fragment,{children:[(0,c.jsx)(o.Z,{id:t.noticeId,title:t.title,content:t.content},t.noticeId),(0,c.jsx)(u.Z,{onClick:w.bind(null,t.noticeId),children:"삭제"})]}))]})}},5651:function(t,n,e){"use strict";e.d(n,{Aw:function(){return m},C3:function(){return b},CS:function(){return F},Cx:function(){return D},Fl:function(){return a},GB:function(){return X},GG:function(){return h},HH:function(){return U},HS:function(){return Z},JQ:function(){return z},JS:function(){return Q},K9:function(){return R},Mk:function(){return O},Mn:function(){return T},NH:function(){return E},NU:function(){return r},O1:function(){return f},OD:function(){return q},OR:function(){return H},Oz:function(){return A},Pk:function(){return p},QC:function(){return C},SQ:function(){return N},Sf:function(){return G},TD:function(){return x},Tk:function(){return l},Tr:function(){return d},XB:function(){return o},XR:function(){return K},bt:function(){return I},dg:function(){return g},eG:function(){return y},fB:function(){return _},fu:function(){return k},i1:function(){return s},kZ:function(){return w},mF:function(){return S},mR:function(){return P},oO:function(){return J},pI:function(){return j},ph:function(){return B},r4:function(){return u},s6:function(){return i},wh:function(){return v},zt:function(){return M}});var c=e(5121);async function o(t){try{return(await c.Z.post("http://ceprj.gachon.ac.kr:60011/user/login",t)).data.token}catch(t){alert("아이디와 비밀번호를 확인해주세요"),console.log(t)}}async function r(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/user/update",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n.data}catch(t){console.log(t)}}async function a(t){try{await c.Z.post("http://ceprj.gachon.ac.kr:60011/user/register",t)}catch(t){console.log(t)}}async function i(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/user/checkId?email=".concat(t));return console.log(n),alert("사용할 수 있는 이메일입니다."),200}catch(t){alert("사용할 수 없는 이메일입니다.")}}async function u(t,n){try{return await c.Z.post("http://ceprj.gachon.ac.kr:60011/board/write",t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){return console.log(t),!1}}async function l(t,n,e){try{let o=await c.Z.post("http://ceprj.gachon.ac.kr:60011/board/".concat(e,"/file/upload"),t,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer ".concat(n)}});console.log(o)}catch(t){return console.log(t),!1}}async function s(t,n,e){try{return await c.Z.patch("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/update"),n,{headers:{Authorization:"Bearer ".concat(e)}}),!0}catch(t){return console.log(t),!1}}async function h(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/board/list?page=".concat(t));return console.log(n),n}catch(t){console.log(t)}}async function d(t){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/board/".concat(t))}catch(t){console.log(t)}}async function p(t){try{await c.Z.delete("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/delete"))}catch(t){console.log(t)}}async function g(t){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/board/search?title=".concat(t,"&content=a&writerName=a"))}catch(t){console.log(t)}}async function f(t){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/list"))}catch(t){console.log(t)}}async function y(t,n,e){try{return await c.Z.post("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/write"),n,{headers:{Authorization:"Bearer ".concat(e)}})}catch(t){console.log(t)}}async function w(t,n,e){try{return await c.Z.delete("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/delete/").concat(n),{headers:{Authorization:"Bearer ".concat(e)}})}catch(t){console.log(t)}}async function m(t,n,e,o){try{return await c.Z.patch("http://ceprj.gachon.ac.kr:60011/board/".concat(t,"/comment/update/").concat(n),e,{headers:{Authorization:"Bearer ".concat(o)}}),!0}catch(t){return console.log(t),!1}}async function _(){try{let t=await c.Z.get("http://ceprj.gachon.ac.kr:60011/inquiry/list");return console.log(t),t}catch(t){console.log(t)}}async function j(t,n){try{return await c.Z.post("http://ceprj.gachon.ac.kr:60011/inquiry/write",t,{headers:{Authorization:"Bearer ".concat(n)}}),!0}catch(t){return console.log(t),!1}}async function k(t,n){try{let e=await c.Z.get("http://ceprj.gachon.ac.kr:60011/inquiry/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}});return console.log(e),e}catch(t){console.log(t)}}async function Z(t){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/admin/user/list?page=".concat(t))}catch(t){console.log(t)}}async function b(t,n){try{await c.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/user/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function x(t){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/admin/board/list?page=".concat(t))}catch(t){console.log(t)}}async function A(t,n){try{let e=await c.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/board/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}});console.log(e)}catch(t){console.log(t)}}async function z(){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/admin/inquiry/list")}catch(t){console.log(t)}}async function B(t,n){try{return await c.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/inquiry/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function v(t,n,e){try{let o=await c.Z.patch("http://ceprj.gachon.ac.kr:60011/admin/inquiry/".concat(t,"/answer"),n,{headers:{Authorization:"Bearer ".concat(e)}});console.log(o)}catch(t){console.log(t)}}async function N(t,n){try{await c.Z.patch("http://ceprj.gachon.ac.kr:60011/mypage/user/update",t,{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function C(t){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/board/list",{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function S(t){try{return await c.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/comment/list",{headers:{Authorization:"Bearer ".concat(t)}})}catch(t){console.log(t)}}async function T(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/inquiry/list",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n}catch(t){console.log(t)}}async function H(t,n){try{await c.Z.delete("http://ceprj.gachon.ac.kr:60011/mypage/user/update/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function O(t,n){try{let e=await c.Z.post("http://61.79.137.116:5000/detect",t,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer ".concat(n)}});return console.log(e),e}catch(t){console.error("업로드 에러:",t)}}async function q(t,n,e){try{t.append("ratio",JSON.stringify({ratio:n}));let o=await c.Z.post("http://ceprj.gachon.ac.kr:60011/history/upload",t,{headers:{"Content-Type":"multipart/form-data",Authorization:"Bearer ".concat(e)}});return console.log(o),o}catch(t){console.error("업로드 에러:",t)}}async function I(t,n){try{let e=await c.Z.get("http://ceprj.gachon.ac.kr:60011/history/download?historyId=".concat(t),{headers:{Authorization:"Bearer ".concat(n)},responseType:"blob"});return console.log(e),e.data}catch(t){console.error("업로드 에러:",t)}}async function E(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/admin/notice/list",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n}catch(t){console.log(t)}}async function M(t,n){try{let e=await c.Z.post("http://ceprj.gachon.ac.kr:60011/admin/notice/write",t,{headers:{Authorization:"Bearer ".concat(n)}});return console.log(e),e}catch(t){console.error("업로드 에러:",t)}}async function Q(t,n){try{await c.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/notice/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function G(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/history/list",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n}catch(t){console.log(t)}}async function J(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/review/list?page=".concat(t));return console.log(n),n}catch(t){console.error("업로드 에러:",t)}}async function R(t,n){try{let e=await c.Z.post("http://ceprj.gachon.ac.kr:60011/review/write",t,{headers:{Authorization:"Bearer ".concat(n)}});return console.log(e),e}catch(t){console.error("업로드 에러:",t)}}async function U(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/review/".concat(t));return console.log(n),n}catch(t){console.error("업로드 에러:",t)}}async function X(t,n,e){try{let o=await c.Z.patch("http://ceprj.gachon.ac.kr:60011/review/".concat(t,"/update"),n,{headers:{Authorization:"Bearer ".concat(e)}});return console.log(o),o}catch(t){console.error("업로드 에러:",t)}}async function F(t,n){try{await c.Z.delete("http://ceprj.gachon.ac.kr:60011/review/".concat(t,"/delete"),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function P(t,n){try{await c.Z.delete("http://ceprj.gachon.ac.kr:60011/admin/review/delete/".concat(t),{headers:{Authorization:"Bearer ".concat(n)}})}catch(t){console.log(t)}}async function D(t){try{let n=await c.Z.get("http://ceprj.gachon.ac.kr:60011/mypage/review/list",{headers:{Authorization:"Bearer ".concat(t)}});return console.log(n),n}catch(t){console.error("업로드 에러:",t)}}async function K(){try{let t=await c.Z.get("http://61.79.137.116:5000/status");return console.log(t),alert("서버가 켜져있어요"),t}catch(t){console.error("업로드 에러:",t),alert("서버가 꺼져있어요")}}},93:function(t,n,e){"use strict";var c=e(5893);e(3935);var o=e(5595),r=e.n(o);let a=t=>(0,c.jsx)("div",{className:r().backdrop,onClick:t.onHide}),i=t=>(0,c.jsx)("div",{className:r().modal,children:(0,c.jsx)("div",{className:r().content,children:t.children})});n.Z=t=>(0,c.jsxs)(c.Fragment,{children:[(0,c.jsx)(a,{onHide:t.onHide}),(0,c.jsx)(i,{children:t.children})]})},115:function(t,n,e){"use strict";e.d(n,{Z:function(){return i}});var c=e(5893),o=e(6028),r=e.n(o),a=e(7294);function i(t){let{id:n,title:e,content:o}=t,[i,u]=(0,a.useState)(!1);return(0,c.jsxs)("div",{className:r().container,onClick:()=>{u(t=>!t)},children:[(0,c.jsx)("div",{className:r().title,children:e}),i&&(0,c.jsx)("div",{className:r().answer,children:(0,c.jsx)("div",{className:r().content,children:o})})]})}},371:function(t){t.exports={box:"information_box__Ma08U",button_box:"information_button_box__v9QUH",wrtie_box:"information_wrtie_box___Qsb9",write_title:"information_write_title__0xobI",write_content:"information_write_content__lZzMq",modal_button:"information_modal_button__CUEfU"}},5595:function(t){t.exports={backdrop:"Modal_backdrop__QE4nN",modal:"Modal_modal__a_Rvo","slide-down":"Modal_slide-down__ujkOP"}},6028:function(t){t.exports={container:"Announcement_container__VtOnJ",title:"Announcement_title__rW57q",content:"Announcement_content__GXgCL",answer:"Announcement_answer___t25H"}}},function(t){t.O(0,[5121,2888,9774,179],function(){return t(t.s=6767)}),_N_E=t.O()}]);