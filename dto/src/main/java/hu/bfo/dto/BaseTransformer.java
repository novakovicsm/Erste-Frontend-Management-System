package hu.bfo.dto;

import hu.bfo.model.BusinessObject;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseTransformer<DTO extends BaseDTO, BO extends BusinessObject> {

	public abstract DTO transformEntityToDTO(BO businessObject)
			throws Exception;

	public abstract BO transformDTOToEntity(DTO dto) throws Exception;

	public abstract List<DTO> transformEntitiesToDTOs(List<BO> businessobjectList)
			throws Exception;

	public abstract List<BO> transformDTOsToEntities(List<DTO> dtoList)
			throws Exception;

	protected DTO transformEntityToDTO(BO businessObject, Class<DTO> dtoClass)
			throws Exception {

		DTO result = dtoClass.newInstance();
		result.setActive(businessObject.getActive());
		result.setId(businessObject.getId());
		return result;
	}

	protected BO transformDTOToEntity(DTO dto, Class<? extends BO> entity)
			throws Exception {

		BO result = entity.newInstance();
		result.setActive(dto.getActive());
		result.setId(dto.getId());
		return result;

	}

	protected List<DTO> transformEntitiesToDTOs(List<BO> businessobjectList,
			Class<DTO> dtoClass) throws InstantiationException,
			IllegalAccessException {

		List<DTO> dtoList = new ArrayList<DTO>();

		for (BO bo : businessobjectList) {

			DTO result = dtoClass.newInstance();
			result.setActive(bo.getActive());
			result.setId(bo.getId());
			dtoList.add(result);
		}

		return dtoList;

	}

	protected List<BO> transformDTOsToEntities(List<DTO> dtoList,
			Class<? extends BO> entity) throws Exception {

		List<BO> entityList = new ArrayList<BO>();

		for (DTO dto : dtoList) {

			BO result = entity.newInstance();
			result.setActive(dto.getActive());
			result.setId(dto.getId());
			entityList.add(result);
		}

		return entityList;
	}
}
