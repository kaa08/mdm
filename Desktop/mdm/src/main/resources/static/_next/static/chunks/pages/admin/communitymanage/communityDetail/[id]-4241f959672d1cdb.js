(self.webpackChunk_N_E=self.webpackChunk_N_E||[]).push([[9346],{7885:function(t,e,n){(window.__NEXT_P=window.__NEXT_P||[]).push(["/admin/communitymanage/communityDetail/[id]",function(){return n(2124)}])},2124:function(t,e,n){"use strict";n.r(e),n.d(e,{default:function(){return l}});var i=n(5893),r=n(5651),a=n(8533),u=n(4107),c=n(1163),o=n(7294),d=n(5007);function l(){let t=(0,c.useRouter)(),e=(0,d.I0)(),[n,l]=(0,o.useState)({}),s=(0,o.useCallback)(async()=>{let e=await (0,r.Tr)(t.query.id);e&&l(e.data)},[t.query.id]);(0,o.useEffect)(()=>{s()},[s]),(0,o.useEffect)(()=>{n.boardId&&e(u.r.addPostDetail(n))},[n,e]);let m=async()=>{try{window.confirm("삭제 하시겠습니까?")&&(await (0,r.Pk)(t.query.id),alert("게시글이 삭제되었습니다.")),t.push("/admin/communitymanage")}catch(t){console.error("게시글 삭제 중 오류가 발생했습니다:",t),alert("게시글 삭제 중 문제가 발생했습니다.")}};return(0,i.jsx)(i.Fragment,{children:n&&(0,i.jsx)(a.Z,{title:n.title,content:n.content,writerName:n.writerName,writerEmail:n.writerEmail,onClickDelete:m,admin:!0},n.boardId)})}}},function(t){t.O(0,[5121,8533,2888,9774,179],function(){return t(t.s=7885)}),_N_E=t.O()}]);