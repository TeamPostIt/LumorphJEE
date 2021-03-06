package com.ludomorph.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ludomorph.beans.web.SpriteVO;
import com.ludomorph.business.ISpriteService;
import com.ludomorph.business.SpriteService;

public class UploadEnemyAction extends Action {

	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest req,
			final HttpServletResponse res) throws Exception {

		SpriteVO uploadForm = (SpriteVO) form;
		ISpriteService service = SpriteService.getInstance();

		String filePath = req.getSession().getServletContext().getRealPath("/");
		int id_user = (int) req.getSession().getAttribute("user_id");

		service.uploadEnnemy(id_user, uploadForm, filePath);

		return mapping.findForward("success");

	}

}
