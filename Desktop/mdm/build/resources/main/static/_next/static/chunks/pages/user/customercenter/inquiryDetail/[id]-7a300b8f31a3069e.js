(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[8638],{5928:function(e,t,n){(window.__NEXT_P=window.__NEXT_P||[]).push(["/user/customercenter/inquiryDetail/[id]",function(){return n(7609)}])},7609:function(e,t,n){"use strict";n.r(t),n.d(t,{default:function(){return c}});var u=n(5893),r=n(5651),i=n(5727),o=n(1163),s=n(7294);function c(){let e=(0,o.useRouter)(),[t,n]=(0,s.useState)();(0,s.useEffect)(()=>{n(localStorage.getItem("loginToken")),console.log(t)},[t]);let[c,a]=(0,s.useState)({}),l=(0,s.useCallback)(async()=>{let n=await (0,r.fu)(e.query.id,t);n&&a(n.data)},[e.query.id]);return(0,s.useEffect)(()=>{l(),console.log(c)},[l]),(0,u.jsx)(u.Fragment,{children:c&&(0,u.jsx)(i.Z,{title:c.title,content:c.contents,writerName:c.writerName,answer_rp:c.answer},c.inquiryId)})}}},function(e){e.O(0,[5121,5727,2888,9774,179],function(){return e(e.s=5928)}),_N_E=e.O()}]);