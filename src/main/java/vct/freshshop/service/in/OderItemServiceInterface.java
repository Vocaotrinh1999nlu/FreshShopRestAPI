package vct.freshshop.service.in;

import vct.freshshop.dto.OderItemDTO;
import vct.freshshop.entity.OderItem;

public interface OderItemServiceInterface extends AbstractServiceInterface<OderItem>{

	OderItemDTO convertToDTO(OderItem oderItem);
}
