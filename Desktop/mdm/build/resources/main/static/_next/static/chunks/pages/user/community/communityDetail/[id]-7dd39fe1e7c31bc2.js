(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[2973],{7416:function(t,e,r){(window.__NEXT_P=window.__NEXT_P||[]).push(["/user/community/communityDetail/[id]",function(){return r(8104)}])},8104:function(t,e,r){"use strict";r.r(e),r.d(e,{default:function(){return l}});var n=r(5893),i=r(5651),u=r(8533),a=r(4107),c=r(1163),o=r(7294),s=r(5007);function l(){let t=(0,c.useRouter)(),e=(0,s.I0)(),[r,l]=(0,o.useState)({}),d=(0,o.useCallback)(async()=>{let e=await (0,i.Tr)(t.query.id);e&&l(e.data)},[t.query.id]);(0,o.useEffect)(()=>{d()},[d]),(0,o.useEffect)(()=>{r.boardId&&e(a.r.addPostDetail(r))},[r,e]);let f=async()=>{try{window.confirm("삭제 하시겠습니까?")&&(await (0,i.Pk)(t.query.id),alert("게시글이 삭제되었습니다.")),t.push("/user/community")}catch(t){console.error("게시글 삭제 중 오류가 발생했습니다:",t),alert("게시글 삭제 중 문제가 발생했습니다.")}};return(0,n.jsx)(n.Fragment,{children:r&&(0,n.jsx)(u.Z,{title:r.title,content:r.content,writerName:r.writerName,writerEmail:r.writerEmail,onClickDelete:f},r.boardId)})}}},function(t){t.O(0,[3365,5121,8533,2888,9774,179],function(){return t(t.s=7416)}),_N_E=t.O()}]);